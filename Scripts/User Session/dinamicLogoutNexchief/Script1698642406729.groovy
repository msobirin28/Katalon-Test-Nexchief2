import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import testCase.handleSession as handleSession
import component.handleComponent as handleComponent

//keyword declaration
def handleSession = new handleSession()
def handleComponent = new handleComponent()

//call logout keyword
//handleSession.logoutuser()
String principalId = principalId

def buttonDoor = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_door_logout')
def buttonLogout = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_logout_from_nexchief')
def buttonBackToPortal = findTestObject('Object Repository/Login.NDI/Page_Nexchief/button_back_to_portal')
def principalSchemaObject = findTestObject('Object Repository/Login.NDI/Page_Nexchief/principalId')

handleComponent.singleClickComponent(buttonDoor)
handleComponent.singleClickComponent(buttonBackToPortal)
handleComponent.singleClickComponentByText(principalSchemaObject, principalId)
handleComponent.singleClickComponent(buttonDoor)
handleComponent.singleClickComponent(buttonLogout)

WebUI.closeBrowser()