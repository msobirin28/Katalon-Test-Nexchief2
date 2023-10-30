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

import component.handleComponent as handleComponent
import testCase.handleSession as handleSession

//keyword declaration
def handleComponent = new handleComponent()
def handleSession = new handleSession()

//variable untuk login
String username = GlobalVariable.username
String password = GlobalVariable.password
String principalId = GlobalVariable.principalId
String nexchiefUrl = GlobalVariable.nexchief2Url

//variable declaration
String reasonCode = reasonCode
String reasonName = reasonName
String reasonCategory = reasonCategory
String reasonRevisitBySalesco = reasonRevisitBySalesco
String reasonMenu = reasonMenu
String expectedResult1 = expectedResult1
String expectedResult2 = expectedResult2

//object declaration
def buttonAdd = findTestObject('Object Repository/Setup.Setup.Reason/button_add_reason')
def inputReasonCode = findTestObject('Object Repository/Setup.Setup.Reason/input_reason_code')
def inputReasonName = findTestObject('Object Repository/Setup.Setup.Reason/input_reason_name')
def selectReasonCategory = findTestObject('Object Repository/Setup.Setup.Reason/select_reason_category')
def selectReasonCategoryItem = findTestObject('Object Repository/Setup.Setup.Reason/select_reason_category_item')
def toggleRevisitBySalesco = findTestObject('Object Repository/Setup.Setup.Reason/toggle_revisit_by_salesco')
def buttonCancel = findTestObject('Object Repository/Setup.Setup.Reason/button_cancel')
def buttonSave = findTestObject('Object Repository/Setup.Setup.Reason/button_save')
def modalsSuccessTitle = findTestObject('Object Repository/Setup.Setup.Reason/label_success')
def modalsSuccessSubTitle = findTestObject('Object Repository/Setup.Setup.Reason/label_success_sub_title')
def buttonOkModal = findTestObject('Object Repository/Setup.Setup.Reason/button_ok_modal')

//login to nexchief (sementara)
handleSession.initLogin(nexchiefUrl)
handleSession.loginUser(username, password, principalId)

//test case add reason
handleComponent.navigateToMenuByUrl(reasonMenu)
handleComponent.singleClickComponent(buttonAdd)
handleComponent.setInputValue(inputReasonCode, reasonCode)
handleComponent.setInputValue(inputReasonName, reasonName)
handleComponent.singleClickComponent(selectReasonCategory)
handleComponent.singleClickComponentByText(selectReasonCategoryItem, reasonCategory)
handleComponent.setToggleValue(toggleRevisitBySalesco, reasonRevisitBySalesco)
handleComponent.singleClickComponent(buttonSave)

//pengecekkan sukses tambah data
handleComponent.compareTextAppearWithExpectedResult(modalsSuccessTitle, expectedResult1)
handleComponent.compareTextAppearWithExpectedResult(modalsSuccessSubTitle, expectedResult2)
handleComponent.singleClickComponent(buttonOkModal)

//logout from nexchief (sementara)
handleSession.logoutuser()
WebUI.closeBrowser()