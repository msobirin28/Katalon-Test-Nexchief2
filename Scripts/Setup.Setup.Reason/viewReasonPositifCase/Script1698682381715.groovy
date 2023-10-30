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

//object declaration
def inputSearch = findTestObject('Object Repository/Setup.Setup.Reason/list_input_search_reason')
def clearSearch = findTestObject('Object Repository/Setup.Setup.Reason/button_clear_search')
def listSearchItem = findTestObject('Object Repository/Setup.Setup.Reason/list_input_search_reason_item')
def buttonDetailIcon = findTestObject('Object Repository/Setup.Setup.Reason/button_detail_icon')
def labelReasonCodeList = findTestObject('Object Repository/Setup.Setup.Reason/label_reason_code_list')
def labelReasonCodeDetail = findTestObject('Object Repository/Setup.Setup.Reason/label_reason_code_detail')
def labelReasonNameDetail = findTestObject('Object Repository/Setup.Setup.Reason/label_reason_name_detail')
def labelReasonCategoryDetail = findTestObject('Object Repository/Setup.Setup.Reason/label_reason_category_detail')
def labelRevisitBySalescoDetail = findTestObject('Object Repository/Setup.Setup.Reason/label_revisit_by_salesco_detail')
def buttonBackToList = findTestObject('Object Repository/Setup.Setup.Reason/button_back_to_list')

//login to nexchief (sementara)
handleSession.initLogin(nexchiefUrl)
handleSession.loginUser(username, password, principalId)

//test case view detail
handleComponent.navigateToMenuByUrl(reasonMenu)
handleComponent.searchDataUsingInputSearchByText(inputSearch, listSearchItem, reasonCode)
handleComponent.singleClickComponent(buttonDetailIcon)
handleComponent.compareObjectTextByText(labelReasonCodeDetail, reasonCode)
handleComponent.compareObjectTextByText(labelReasonNameDetail, reasonName)
handleComponent.compareObjectTextByText(labelReasonCategoryDetail, reasonName)
handleComponent.compareObjectTextByText(labelRevisitBySalescoDetail, reasonRevisitBySalesco)

//logout from nexchief (sementara)
handleSession.logoutuser()
WebUI.closeBrowser()