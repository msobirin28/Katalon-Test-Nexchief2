package testCase

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

import component.handleComponent as handleComponent

import internal.GlobalVariable

public class handleSession {
	def handleComponent = new handleComponent()
	
	@Keyword
	def initLogin(String value) {
		WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)
		WebUI.navigateToUrl(value, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def loginUser(String username, String password, String principalId) {
		def usernameObject = findTestObject('Object Repository/Login.NDI/Page_Nexchief/input_Selamat Datang_username')
		def passwordObject = findTestObject('Object Repository/Login.NDI/Page_Nexchief/input_Selamat Datang_password')
		def buttonLogin = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_Masuk')
		def loginDeniedLabel = findTestObject('Object Repository/Login.NDI/Page_Nexchief/div_Login Denied')
		def buttonKickUser = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_Yes, Logout')
		def principalSchemaObject = findTestObject('Object Repository/Login.NDI/Page_Nexchief/principalId')
		
		handleComponent.setInputValue(usernameObject, username)
		handleComponent.setInputValue(passwordObject, password)
		handleComponent.singleClickComponent(buttonLogin)
		if(WebUI.verifyElementPresent(loginDeniedLabel, 1, FailureHandling.OPTIONAL)) {
			handleComponent.singleClickComponent(buttonKickUser)
		}
		handleComponent.singleClickComponentByText(principalSchemaObject, principalId)
	}
	
	@Keyword
	def logoutuser() {
		def buttonDoor = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_door_logout')
		def buttonLogout = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_logout_from_nexchief')
		
		handleComponent.singleClickComponent(buttonDoor)
		handleComponent.singleClickComponent(buttonLogout)
	}
	
	@Keyword
	def changeSchema(String principalId) {
		def buttonDoor = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_door_logout')
		def buttonBackToPortal = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_back_to_portal')
		def principalSchemaObject = findTestObject('Object Repository/Login.NDI/Page_Nexchief/principalId')
		
		handleComponent.singleClickComponent(buttonDoor)
		handleComponent.singleClickComponent(buttonBackToPortal)
		handleComponent.singleClickComponentByText(principalSchemaObject, principalId)
	}
}
