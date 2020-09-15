package com.training.rentapartment.controller.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;

public class PaginationTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(PaginationTag.class);
    private static final int FIRST_PAGE = 1;

    private static final String A_TAG_OPEN = "<a ";
    private static final String DIV_TAG_OPEN = "<div ";

    private static final String A_TAG_CLOSE = "</a>";
    private static final String DIV_TAG_CLOSE = "</div>";

    private static final String HREF_START = " href=\"";
    private static final String CLASS_START = " class=\"";

    private static final String TAG_START_CLOSE = ">";
    private static final String TAG_ATTRIBUTE_END = "\" ";

    private static final String FIRST_REQUEST_PARAMETER_IDENTIFIER = "?";
    private static final String REQUEST_PARAMETER_IDENTIFIER = "&";
    private static final String EQUALS = "=";

    private static final String PAGE = "page";

    private int page;
    private int itemsAmount;
    private int amountOfItemsOnPage;
    private String paginationWrapperClass;
    private String prevButtonClass;
    private String nextButtonClass;
    private String prevValue;
    private String nextValue;

    public void setPage(int page) {
        this.page = page;
    }

    public void setItemsAmount(int itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public void setAmountOfItemsOnPage(int amountOfItemsOnPage) {
        this.amountOfItemsOnPage = amountOfItemsOnPage;
    }

    public void setPaginationWrapperClass(String paginationWrapperClass) {
        this.paginationWrapperClass = paginationWrapperClass;
    }

    public void setPrevButtonClass(String prevButtonClass) {
        this.prevButtonClass = prevButtonClass;
    }

    public void setNextButtonClass(String nextButtonClass) {
        this.nextButtonClass = nextButtonClass;
    }

    public void setPrevValue(String prevValue) {
        this.prevValue = prevValue;
    }

    public void setNextValue(String nextValue) {
        this.nextValue = nextValue;
    }

    @Override
    public int doStartTag() throws JspException {
        int pageAmount = calculatePageAmount(itemsAmount, amountOfItemsOnPage);

        if (page < FIRST_PAGE) {
            page = FIRST_PAGE;
        }
        if (page > pageAmount) {
            page = pageAmount;
        }

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();

        if (pageAmount != FIRST_PAGE) {
            StringBuilder tag = buildTag(parameterMap, pageAmount);
            try {
                JspWriter writer = pageContext.getOut();
                writer.write(tag.toString());
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
                throw new JspException(e.getMessage(), e);
            }
        }
        return SKIP_BODY;
    }

    private StringBuilder buildTag(Map<String, String[]> parameterMap, int pageAmount) {
        StringBuilder tag = buildWrapperOpener();
        if (page != FIRST_PAGE) {
            tag.append(buildGoToPageATag(page - 1, prevValue, parameterMap, prevButtonClass));
        }
        if (page != pageAmount) {
            tag.append(buildGoToPageATag(page + 1, nextValue, parameterMap, nextButtonClass));
        }
        tag.append(DIV_TAG_CLOSE);
        return tag;
    }

    private StringBuilder buildGoToPageATag(int pageNumber, String buttonText, Map<String, String[]> parameterMap, String className) {
        StringBuilder goToPageATag = new StringBuilder();
        goToPageATag.append(A_TAG_OPEN);
        goToPageATag.append(HREF_START);
        goToPageATag.append(FIRST_REQUEST_PARAMETER_IDENTIFIER);
        goToPageATag.append(buildParameterString(parameterMap));
        goToPageATag.append(PAGE);
        goToPageATag.append(EQUALS);
        goToPageATag.append(pageNumber);
        goToPageATag.append(TAG_ATTRIBUTE_END);
        goToPageATag.append(CLASS_START);
        goToPageATag.append(className);
        goToPageATag.append(TAG_ATTRIBUTE_END);
        goToPageATag.append(TAG_START_CLOSE);
        goToPageATag.append(buttonText);
        goToPageATag.append(A_TAG_CLOSE);
        return goToPageATag;
    }

    private int calculatePageAmount(int itemsAmount, int amountOfItemsOnPage) {
        int fullPages = itemsAmount / amountOfItemsOnPage;
        boolean allPagesAreFull = itemsAmount % amountOfItemsOnPage == 0;
        return allPagesAreFull ? fullPages : fullPages + 1;
    }

    private StringBuilder buildParameterString(Map<String, String[]> parameters) {
        StringBuilder parameterString = new StringBuilder();
        parameters.forEach((key, value) -> {
            if (!key.equals(PAGE)) {
                parameterString.append(key + EQUALS + value[0] + REQUEST_PARAMETER_IDENTIFIER);
            }
        });
        return parameterString;
    }

    private StringBuilder buildWrapperOpener() {
        StringBuilder tag = new StringBuilder();
        tag.append(DIV_TAG_OPEN);
        tag.append(CLASS_START);
        tag.append(paginationWrapperClass);
        tag.append(TAG_ATTRIBUTE_END);
        tag.append(TAG_START_CLOSE);
        return tag;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
