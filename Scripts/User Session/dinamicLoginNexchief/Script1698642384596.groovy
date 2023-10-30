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

//declaration keyword
def handleSession = new handleSession()
def handleComponent = new handleComponent()

//deklarasi variable
String username = username

String password = password

String principalId = principalId

String URL = GlobalVariable.nexchief2Url

////login
handleSession.initLogin(URL)
//handleSession.loginUser(username, password, principalId)

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