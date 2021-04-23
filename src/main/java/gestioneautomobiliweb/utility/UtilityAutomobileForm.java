package gestioneautomobiliweb.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import gestioneautomobiliweb.model.Automobile;

public class UtilityAutomobileForm {

	public static boolean validateInput(String marcaInputParameter, String modelloInputParameter,
			String cilindrataInputParameter, String dataImmatricolazioneInputParameter) {

		if (StringUtils.isBlank(marcaInputParameter) || StringUtils.isBlank(modelloInputParameter)
				|| !NumberUtils.isCreatable(cilindrataInputParameter)
				|| StringUtils.isBlank(dataImmatricolazioneInputParameter)) {

			return false;
		}

		if (!validateIntCilindrata(cilindrataInputParameter)) {
			return false;
		}

		return true;

	}

	public static Automobile createBin(String marcaInputParameter, String modelloInputParameter,
			String cilindrataInputParameter, String dataImmatricolazioneInputParameter) {

		Automobile automobileBin = new Automobile(marcaInputParameter, modelloInputParameter);

		if (validateIntCilindrata(cilindrataInputParameter)) {
			automobileBin.setCilindrata(Integer.parseInt(cilindrataInputParameter));
		}

		automobileBin
				.setDataDiImmatricolazione(parseDataImmatricolazioneFromString(dataImmatricolazioneInputParameter));

		return automobileBin;

	}

	public static Date parseDataImmatricolazioneFromString(String dataImmatricolazioneInputParameter) {
		if (StringUtils.isBlank(dataImmatricolazioneInputParameter))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataImmatricolazioneInputParameter);
		} catch (ParseException e) {
			return null;
		}
	}

	public static boolean validateIntCilindrata(String cilindrataInputParameter) {

		if (!NumberUtils.isCreatable(cilindrataInputParameter)
				|| NumberUtils.toInt(cilindrataInputParameter, -1) == -1) {
			return false;
		}
		if (Integer.parseInt(cilindrataInputParameter) < 1) {
			return false;
		}
		return true;
	}

}
