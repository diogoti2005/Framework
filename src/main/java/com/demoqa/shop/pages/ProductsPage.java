package com.demoqa.shop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='noo-site']//select[@name='filter_color']")
    private WebElement selectColor;

    @FindBy(xpath = "(//select[@class = 'noo-woo-filter']//option[contains(text(), 'Filter color')])[1]")
    private WebElement defaultColor;

    @FindBy(xpath = "//body/div[@id='noo-site']//select[@name='filter_size']")
    private WebElement selectSize;

    @FindBy(xpath = "(//select[@class = 'noo-woo-filter']//option[contains(text(), 'Filter size')])[1]")
    private WebElement defaultSize;

    @FindBy(xpath = "//body/div[@id='noo-site']//select[@name='filter_style']")
    private WebElement selectViewStyle;

    @FindBy(xpath = "//div[contains(@class, 'noo-product-item')]")
    private WebElement gridView;

    @FindBy(xpath = "//body/div[@id='noo-site']//select[@name='orderby']")
    private WebElement selectOrder;

    @FindBy(xpath = "(//select[@class = 'orderby']//option[@value='menu_order'])[1]")
    private WebElement defaultOrder;

    @FindBy(xpath = "//p[contains(text(),'41 results')]")
    private WebElement allElements;

    @FindBy(xpath = "(//img[@class='product-one-thumb'])[1]")
    private WebElement fisrstItem;

    @FindBy(xpath = "//select[@id = 'pa_color']//option[@value='black']")
    private WebElement itemColorBlack;

    @FindBy(xpath = "//select[@id = 'pa_color']//option[@value='white']")
    private WebElement itemColorWhite;

    @FindBy(xpath = "//select[@id = 'pa_size']//option[@value='32']")
    private WebElement itemSize32;

    @FindBy(xpath = "//select[@id = 'pa_size']//option[@value='medium']")
    private WebElement itemSizeMedium;

    @FindBy(xpath = "//select[@id = 'pa_size']//option[@value='large']")
    private WebElement itemSizeLarge;

    @FindBy(xpath = "//div[contains(@class, 'product-list') and contains(@class, 'product-type-variable')]")
    private WebElement listView;

    @FindBy(xpath = "(//h3//a[contains(@href, 'shop.demoqa.com/product/')])[1]")
    private WebElement itemTitle;

    @FindBy(xpath = "(//span[@class='posted_in'])[1]")
    private WebElement category;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    private WebElement price;

    @FindBy(xpath = "(//div[@class='noo-product-inner-content']//p)[1]")
    private WebElement description;

    @FindBy(xpath = "(//div[@class='product-list-meta'])[1]")
    private WebElement actionOptions;

    public void selectColor(String value) {
        Select dropDown = new Select(selectColor);
        dropDown.selectByValue(value);
    }

    public void selectSize(String value) {
        Select dropDown = new Select(selectSize);
        dropDown.selectByValue(value);
    }

    public void selectStyle(String value) {
        Select dropDown = new Select(selectViewStyle);
        dropDown.selectByValue(value);
    }

    public void selectOrder(String value) {
        Select dropDown = new Select(selectOrder);
        dropDown.selectByValue(value);
    }

    public WebElement getDefaultColor() {
        return defaultColor;
    }

    public WebElement getDefaultSize() {
        return defaultSize;
    }

    public WebElement getDefaultOrder() {
        return defaultOrder;
    }

    public WebElement getGridView() {
        return gridView;
    }

    public WebElement getAllElements() {
        return allElements;
    }

    public WebElement getFisrstItem() {
        return fisrstItem;
    }

    public WebElement getItemColorBlack() {
        return itemColorBlack;
    }

    public WebElement getItemSize32() {
        return itemSize32;
    }

    public WebElement getItemColorWhite() {
        return itemColorWhite;
    }

    public WebElement getItemSizeLarge() {
        return itemSizeLarge;
    }

    public WebElement getItemSizeMedium() {
        return itemSizeMedium;
    }

    public WebElement getListView() {
        return listView;
    }

    public WebElement getItemTitle() {
        return itemTitle;
    }

    public WebElement getCategory() {
        return category;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getActionOptions() {
        return actionOptions;
    }

    @Override
    public String getUrl() {
        return "http://shop.demoqa.com/shop/";
    }

    @Override
    public String getTitle() {
        return "Products Page";
    }

}
