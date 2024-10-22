package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private BaseElement typosLink;

    public HomePage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);

        this.typosLink = new BaseElement(
                By.xpath("//a[normalize-space()='Typos']"),
                "Typos link"
        );
    }

    public BaseElement getTyposLink() {
        return this.typosLink;
    }

    public HomePage openABTestingPage() {
        this.getByText("A/B Testing").doClick();
        return this;
    }

    public HomePage openAddRemoveElementsPage() {
        this.getByText("Add/Remove Elements").doClick();
        return this;
    }

    public HomePage openBasicAuthPage() {
        this.getByText("Basic Auth").doClick();
        return this;
    }

    public HomePage openBrokenImagesPage() {
        this.getByText("Broken Images").doClick();
        return this;
    }

    public HomePage openChallengingDOMPage() {
        this.getByText("Challenging DOM").doClick();
        return this;
    }

    public HomePage openCheckboxesPage() {
        this.getByText("Checkboxes").doClick();
        return this;
    }

    public HomePage openContextMenuPage() {
        this.getByText("Context Menu").doClick();
        return this;
    }

    public HomePage openDigestAuthPage() {
        this.getByText("Digest Authentication").doClick();
        return this;
    }

    public HomePage openDisappearingElementsPage() {
        this.getByText("Disappearing Elements").doClick();
        return this;
    }

    public HomePage openDragAndDropPage() {
        this.getByText("Drag and Drop").doClick();
        return this;
    }

    public HomePage openDropdownPage() {
        this.getByText("Dropdown").doClick();
        return this;
    }

    public HomePage openDynamicContentPage() {
        this.getByText("Dynamic Content").doClick();
        return this;
    }

    public HomePage openDynamicControlsPage() {
        this.getByText("Dynamic Controls").doClick();
        return this;
    }

    public HomePage openDynamicLoadingPage() {
        this.getByText("Dynamic Loading").doClick();
        return this;
    }

    public HomePage openEntryAdPage() {
        this.getByText("Entry Ad").doClick();
        return this;
    }

    public HomePage openExitIntentPage() {
        this.getByText("Exit Intent").doClick();
        return this;
    }

    public HomePage openFileDownloadPage() {
        this.getByText("File Download").doClick();
        return this;
    }

    public HomePage openFileUploadPage() {
        this.getByText("File Upload").doClick();
        return this;
    }

    public HomePage openForgotPasswordPage() {
        this.getByText("Forgot Password").doClick();
        return this;
    }

    public HomePage openFormAuthenticationPage() {
        this.getByText("Form Authentication").doClick();
        return this;
    }

    public HomePage openFramesPage() {
        this.getByText("Frames").doClick();
        return this;
    }

    public HomePage openIFramePage() {
        this.getByText("iFrame").doClick();
        return this;
    }

    public HomePage openGeolocationPage() {
        this.getByText("Geolocation").doClick();
        return this;
    }

    public HomePage openHorizontalSliderPage() {
        this.getByText("Horizontal Slider").doClick();
        return this;
    }

    public HomePage openHoversPage() {
        this.getByText("Hovers").doClick();
        return this;
    }

    public HomePage openInfiniteScrollPage() {
        this.getByText("Infinite Scroll").doClick();
        return this;
    }

    public HomePage openInputsPage() {
        this.getByText("Inputs").doClick();
        return this;
    }

    public HomePage openJQueryUIMenusPage() {
        this.getByText("JQuery UI Menus").doClick();
        return this;
    }

    public HomePage openJSAlertsPage() {
        this.getByText("JavaScript Alerts").doClick();
        return this;
    }

    public HomePage openJSOnloadEventErrorPage() {
        this.getByText("JavaScript onload event error").doClick();
        return this;
    }

    public HomePage openKeyPressesPage() {
        this.getByText("Key Presses").doClick();
        return this;
    }

    public HomePage openLargeAndDeepDOMPage() {
        this.getByText("Large & Deep DOM").doClick();
        return this;
    }

    public HomePage openMultipleWindowsPage() {
        this.getByText("Multiple Windows").doClick();
        return this;
    }

    public HomePage openNestedFramesPage() {
        this.getByText("Nested Frames").doClick();
        return this;
    }

    public HomePage openNotificationMessagesPage() {
        this.getByText("Notification Messages").doClick();
        return this;
    }

    public HomePage openRedirectLinkPage() {
        this.getByText("Redirect Link").doClick();
        return this;
    }

    public HomePage openSecureFileDownloadPage() {
        this.getByText("Secure File Download").doClick();
        return this;
    }

    public HomePage openShadowDOMPage() {
        this.getByText("Shadow DOM").doClick();
        return this;
    }

    public HomePage openShiftingContentPage() {
        this.getByText("Shifting Content").doClick();
        return this;
    }

    public HomePage openSlowResourcesPage() {
        this.getByText("Slow Resources").doClick();
        return this;
    }

    public HomePage openSortableDataTablesPage() {
        this.getByText("Sortable Data Tables").doClick();
        return this;
    }

    public HomePage openStatusCodesPage() {
        this.getByText("Status Codes").doClick();
        return this;
    }

    public HomePage openTyposPage() {
        this.getByText("Typos").doClick();
        return this;
    }

    public HomePage openWYSIWYGEditorPage() {
        this.getByText("WYSIWYG Editor").doClick();
        return this;
    }
}
