package beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.validation.constraints.Size;

public class ValvetBean {
	@Size(min = 1, max = 30)
	private String textboxValue;

	@Size(min = 1, max = 30)
	private String chosenRadio;

	@Size(min = 1, max = 30)
	private String chosenSelect;

	public String getTextboxValue() {
		return textboxValue;
	}

	public void setTextboxValue(String textboxValue) {
		this.textboxValue = textboxValue;
	}

	public String getChosenRadio() {
		return chosenRadio;
	}

	public void setChosenRadio(String chosenRadio) {
		this.chosenRadio = chosenRadio;
	}

	public String getChosenSelect() {
		return chosenSelect;
	}

	public void setChosenSelect(String chosenSelect) {
		this.chosenSelect = chosenSelect;
	}

	public String getChosenCheckbox() {
		return chosenCheckbox;
	}

	public void setChosenCheckbox(String chosenCheckbox) {
		this.chosenCheckbox = chosenCheckbox;
	}

	public String getExpectedText() {
		return expectedText;
	}

	public void setExpectedText(String expectedText) {
		this.expectedText = expectedText;
	}

	public String getExpectedRadio() {
		return expectedRadio;
	}

	public void setExpectedRadio(String expectedRadio) {
		this.expectedRadio = expectedRadio;
	}

	public String getExpectedSelect() {
		return expectedSelect;
	}

	public void setExpectedSelect(String expectedSelect) {
		this.expectedSelect = expectedSelect;
	}

	public String getExpectedCheckbox() {
		return expectedCheckbox;
	}

	public void setExpectedCheckbox(String expectedCheckbox) {
		this.expectedCheckbox = expectedCheckbox;
	}

	public Map<String, String> getRadioList() {
		return radioList;
	}

	public void setRadioList(Map<String, String> radioList) {
		this.radioList = radioList;
	}

	public Map<String, String> getSelectList() {
		return selectList;
	}

	public void setSelectList(Map<String, String> selectList) {
		this.selectList = selectList;
	}

	public Map<String, String> getCheckboxList() {
		return checkboxList;
	}

	public void setCheckboxList(Map<String, String> checkboxList) {
		this.checkboxList = checkboxList;
	}
	
	@Size(min = 1, max = 30)
	private String chosenForbiddenCheckbox;

	@Size(min = 1, max = 30)
	private String chosenCheckbox;

	@Size(min = 1, max = 30)
	private String expectedText;

	@Size(min = 1, max = 30)
	private String expectedRadio;

	@Size(min = 1, max = 30)
	private String expectedSelect;

	@Size(min = 1, max = 30)
	private String expectedCheckbox;
	
	@Size(min = 1, max = 30)
	private String expectedForbiddenCheckbox;
	

	public String getChosenForbiddenCheckbox() {
		return chosenForbiddenCheckbox;
	}

	public void setChosenForbiddenCheckbox(String chosenForbiddedCheckbox) {
		this.chosenForbiddenCheckbox = chosenForbiddedCheckbox;
	}

	public String getExpectedForbiddenCheckbox() {
		return expectedForbiddenCheckbox;
	}

	public void setExpectedForbiddenCheckbox(String expectedForbiddenCheckbox) {
		this.expectedForbiddenCheckbox = expectedForbiddenCheckbox;
	}

	private Map<String, String> radioList;
	private Map<String, String> selectList;
	private Map<String, String> checkboxList;
	private Map<String, String> forbiddenCheckboxList;
	


	public Map<String, String> getForbiddenCheckboxList() {
		return forbiddenCheckboxList;
	}

	public void setForbiddenCheckboxList(Map<String, String> forbiddenCheckboxList) {
		this.forbiddenCheckboxList = forbiddenCheckboxList;
	}

	public void setNewValues() {
		Random rnd = new Random();
		expectedText = "" + rnd.nextInt(1000);
		expectedRadio = "" + radioList.get(radioList.keySet().toArray()[rnd.nextInt(radioList.keySet().size())]);
		expectedSelect = "" + selectList.get(selectList.keySet().toArray()[rnd.nextInt(selectList.keySet().size())]);
		expectedCheckbox = "" + checkboxList.get(checkboxList.keySet().toArray()[rnd.nextInt(checkboxList.keySet().size())]);
		expectedForbiddenCheckbox = "";
		chosenForbiddenCheckbox = "" + forbiddenCheckboxList.get(forbiddenCheckboxList.keySet().toArray()[rnd.nextInt(forbiddenCheckboxList.keySet().size())]);
	}

	private void populateLists() {
		radioList = new HashMap<String, String>();
		selectList = new HashMap<String, String>();
		checkboxList = new HashMap<String, String>();
		forbiddenCheckboxList = new HashMap<String, String>();

		radioList.put("1", "1");
		radioList.put("2", "2");
		radioList.put("3", "3");
		radioList.put("4", "4");
		radioList.put("5", "5");

		selectList.put("1", "1");
		selectList.put("2", "2");
		selectList.put("3", "3");
		selectList.put("4", "4");
		selectList.put("5", "5");

		checkboxList.put("1", "1");
		checkboxList.put("2", "2");
		checkboxList.put("3", "3");
		checkboxList.put("4", "4");
		checkboxList.put("5", "5");
		
		forbiddenCheckboxList.put("1", "1");
		forbiddenCheckboxList.put("2", "2");
		forbiddenCheckboxList.put("3", "3");
		forbiddenCheckboxList.put("4", "4");
		forbiddenCheckboxList.put("5", "5");
		forbiddenCheckboxList.put("6", "6");
		forbiddenCheckboxList.put("7", "7");


	}

	public ValvetBean() {
		populateLists();
	}



}
