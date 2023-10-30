package component

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement

import internal.GlobalVariable

public class handleComponent {

	@Keyword
	def setInputValue(TestObject findTestObject, String value) {
		WebUI.verifyElementPresent(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject, value, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def singleClickComponent(TestObject findTestObject) {
		WebUI.verifyElementPresent(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def singleClickComponentByText(TestObject findTestObject, String value) {
		WebUI.verifyElementPresent(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)
		List<WebElement> elements = WebUI.findWebElements(findTestObject, 10)

		for (WebElement element : elements) {
			String text = element.getText()
			if (text == value) {
				element.click()
				break
			}
		}
	}

	@Keyword
	def setToggleValue (TestObject findTestObject, String value) {
		WebUI.verifyElementPresent(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)
		String ariaCheckedValue = WebUI.getAttribute(findTestObject, 'aria-checked', FailureHandling.STOP_ON_FAILURE)

		if (ariaCheckedValue.toLowerCase() == value.toLowerCase()) {
			println("Toggle is already set to the desired value: " + value)
		} else {
			WebUI.click(findTestObject, FailureHandling.STOP_ON_FAILURE)
			println("Toggled to the value: " + value)
		}
	}
}
