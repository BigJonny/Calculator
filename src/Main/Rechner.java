package Main;

import java.awt.Point;
import java.util.ArrayList;

import Opperatoren.Opperator;
import Opperatoren.OpperatorHandler;

/**
 * Diese Klasse berechnet aus einem gültigem String der eine mathematische
 * Aussage darstellt ein Ergebnis
 * 
 * @author Jonas
 *
 */
public class Rechner {

	private ArrayList rechnung = new ArrayList();
	private Interpreter interpreter = new Interpreter();
	private Konstanten kons = new Konstanten();
	OpperatorHandler opHandler = new OpperatorHandler();
	private Variablen variablen = new Variablen();
	private String ausgabe = "";

	/**
	 * Hier wird eine Ausgabe generiert und an die Main-Klasse gegeben
	 * 
	 * @param eingabe
	 *            Eingabe anhand derer Die Ausgabe definiert wird
	 * @return
	 */
	public String getAusgabe(String eingabe) {
		eingabe = kons.checkInput(eingabe);
		eingabe = variablen.containsVars(eingabe);
		if (prüfeGleichung(eingabe) == true) {
			
		} else {
			generateRechnung(eingabe);
		}
		return ausgabe;
	}

	/**
	 * Prüft einen String auf eine Gleichung und löst diese auf
	 * 
	 * @param eingabe
	 *            zu prüfender String
	 * @return True falls die Gleichung korrekt ist ansonten False
	 */
	private boolean prüfeGleichung(String eingabe) {
		boolean isGleichung = false;
		int gZ = -1;
		String links = "";
		String rechts = "";
		if (eingabe.contains("=")) {
			isGleichung = true;
			gZ = eingabe.indexOf("=");
			links = eingabe.substring(0, gZ);
			rechts = eingabe.substring(gZ + 1);
			generateRechnung(links);
			links = ausgabe;
			generateRechnung(rechts);
			rechts = ausgabe;
			Double a = Double.parseDouble(rechts);
			Double b = Double.parseDouble(links);
			if (a.equals(b)) {
				ausgabe = "True";
			} else {
				ausgabe = "False";
			}
			return true;
		}
		return false;
	}

	/**
	 * Generiert eine ArrayList mit der später gerechnet werden soll eine
	 * gültige Liste wäre z.B {12342,+,2412} So stellt jedes zweite Element ein
	 * Opperator dar und die jeweils nächste eine rationale Zahl 1.1 wurde
	 * erweiter durch Klammer und Funktionen
	 */
	private void generateRechnung(String eingabe) {
		rechnung.clear();
		String currentR = eingabe.trim();// Der String aus dem gelesen wird
		String currentElement = ""; // Das aktuelle Element im String currentR
		int klammern = 0;// zählt alle Klammern
		boolean wrongSyntax = false;// ist true falls
		int lastElement = -1; // 0 = Zahl; 1 = Rechenzeichen; 2 = Opperator; 3 =
								// ")" Klammer; 4 = "(" Klammer ; "," = 5
		currentR = currentR.trim();
		if (interpreter.getNumber(currentR).isEmpty() == true) {
			klammern++;
			currentElement = interpreter.getOpperator(currentR);
			currentR = fillRechnung(currentElement, currentR);
			lastElement = 2;
		} else if (currentR.charAt(0) == '(') {
			currentElement = "(";
			currentR = fillRechnung(currentElement, currentR);
			lastElement = 4;
		} else {
			currentElement = interpreter.getNumber(currentR);
			currentR = fillRechnung(currentElement, currentR);
			lastElement = 0;
		}
		boolean rightOrder = true;
		while (currentR.isEmpty() == false && rightOrder == true) {
			currentR = currentR.trim();
			// Falls eine Zahl gefunden wurde
			if (interpreter.getNumber(currentR).isEmpty() == false) {
				if (lastElement == 1 || lastElement == 2 || lastElement == 4 || lastElement == 5) {
					currentElement = interpreter.getNumber(currentR);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 0;
				} else {
					rightOrder = false;
				}
			}
			// Falls ein Rechenzeiche gefunden wurde
			else if (interpreter.getRechenzeichen(currentR).isEmpty() == false) {
				if (lastElement == 0 || lastElement == 3) {
					currentElement = interpreter.getRechenzeichen(currentR);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 1;
				} else {
					rightOrder = false;
				}
			}
			// Falls ein Opperator gefunden wurde
			else if (interpreter.getOpperator(currentR).isEmpty() == false) {
				if (lastElement == 1 || lastElement == 4) {
					klammern++;
					currentElement = interpreter.getOpperator(currentR);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 2;
				} else {
					rightOrder = false;
				}
			}
			// Falls eine geschlossene Klammer gefunden wurde
			else if (currentR.charAt(0) == ')') {
				if (lastElement == 0 || lastElement == 3) {
					klammern--;
					currentElement = "" + currentR.charAt(0);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 3;
				} else {
					rightOrder = false;
				}
			} else if (currentR.charAt(0) == '(') {
				if (lastElement == 1 || lastElement == 2 || lastElement == 4) {
					klammern++;
					currentElement = "" + currentR.charAt(0);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 4;
				} else {
					rightOrder = false;
				}
			}
			// Falls ein Komma gefunden wird
			else if (currentR.charAt(0) == ',') {
				if (lastElement == 2 || lastElement == 0 && klammern > 0) {
					currentElement = "" + currentR.charAt(0);
					currentR = fillRechnung(currentElement, currentR);
					lastElement = 5;
				}
			} else {
				currentR = "";
				wrongSyntax = true;
				ausgabe = "Keine gültige Eingabe\n" + "Error: Falsche Syntax";
			}

			if (klammern < 0) {
				rechnung.clear();
				ausgabe = "Keine gültige Eingabe\n" + "Error: Klammern falsch gesetzt";
				break;
			}

		}
		if (rightOrder == false) {
			ausgabe = "Keine gültige Eingabe\n" + "Error: Falsche Reihenfolge oder Syntax";
		} else {
			if (rechnung.isEmpty() == false && wrongSyntax == false) {
				while (rechnung.contains("(") == true || rechnung.contains(")") == true
						|| opHandler.contains(rechnung) == true) {
					prepareList();
					if (ausgabe == "Error") {
						rechnung.clear();
						rechnung.add("Ungültige Eingabe\nError: Eine Funktion wurde überladen");
					}
				}
				while (rechnung.size() != 1 && ausgabe != "Error") {
					figureOut(rechnung);
				}
				ausgabe = rechnung.get(0).toString();
			}
		}

	}

	/**
	 * Füllt das Array rechnung mit dem Element part und löscht dieses aus dem
	 * String rest und gibt diesen zurück.
	 * 
	 * @param part
	 * @param rest
	 */
	private String fillRechnung(String part, String rest) {
		if (part != "") {
			rechnung.add(part);
			rest = rest.substring(part.length());
		}
		return rest;
	}

	/**
	 * Diese Methode dient nur zum Testen der ArrayList "rechnung" in wie weit
	 * diese Klasse das enprechende Array korrekt befüllt hat
	 */
	private void printRechnung(ArrayList list) {
		System.out.print("{");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ",");
		}
		System.out.print("}\n");
	}

	/**
	 * Berechnet aus dem gegeben Array einen absoluten Wert, bei dieser Methode
	 * ist zu beachten dass das Array vorher noch bearbeitet werden muss es
	 * dürfen keine weiteren Zeichen außer Zahlen und Rechenzeichen mehr
	 * vorhanden sein, asonsten führt diese Methode zu einign Fehlermeldungen Es
	 * ist empfehlenswert diese Methode in einer Schleife zu verwenden, da bei
	 * jedem Durchlauf nur eine Rechnung durchgeführt wird.
	 * 
	 * @return berechneter Rückgabewert
	 */
	private void figureOut(ArrayList rPart) {
		double a = 0;
		double b = 0;
		String newEle = "";
		try {
			for (int i = 0; i < rPart.size(); i++) {
				if (rPart.get(i).equals("*")) {
					a = Double.parseDouble(rPart.get(i - 1).toString());
					b = Double.parseDouble(rPart.get(i + 1).toString());
					newEle = String.valueOf(a * b);
					rPart.set(i - 1, newEle);
					rPart.remove(i);
					rPart.remove(i);
					break;
				} else if (rPart.get(i).equals(":")) {
					a = Double.parseDouble(rPart.get(i - 1).toString());
					b = Double.parseDouble(rPart.get(i + 1).toString());
					newEle = String.valueOf(a / b);
					rPart.set(i - 1, newEle);
					rPart.remove(i);
					rPart.remove(i);
					break;
				} else if (rPart.get(i).equals("+") && rPart.contains("*") == false && rPart.contains(":") == false) {
					a = Double.parseDouble(rPart.get(i - 1).toString());
					b = Double.parseDouble(rPart.get(i + 1).toString());
					newEle = String.valueOf(a + b);
					rPart.set(i - 1, newEle);
					rPart.remove(i);
					rPart.remove(i);
					break;
				} else if (rPart.get(i).equals("-") && rPart.contains("*") == false && rPart.contains(":") == false) {
					a = Double.parseDouble(rPart.get(i - 1).toString());
					b = Double.parseDouble(rPart.get(i + 1).toString());
					newEle = String.valueOf(a - b);
					rPart.set(i - 1, newEle);
					rPart.remove(i);
					rPart.remove(i);
					break;
				}
			}
		} catch (Exception e) {
			ausgabe = "Error";
		}
	}

	/**
	 * Prüft das rechnungsArray auf Klammer und gibt die Stellen der innersten
	 * Klammer zurück als Punkt
	 * 
	 * @return Indize der innersten Klammern
	 */
	private Point getFirstKlammer() {
		Point p = new Point(-1, -1);
		int j = 0;
		for (int i = rechnung.size() - 1; i >= 0; i--) {
			if (rechnung.get(i).equals(")")) {
				p.y = i;
			}
		}
		if (p.y != -1) {
			for (int i = 0; i < (int) p.getY(); i++) {
				if (opHandler.getIDByOp(
						rechnung.get(i).toString().substring(0, rechnung.get(i).toString().length() - 1)) != -1
						|| rechnung.get(i).toString().equals("(")) {
					p.x = i;
				}
			}
		}
		return p;
	}
	
	/**
	 * Berechnet alle geklammerten Aussagen inklusive der Opperatoren aus und
	 * fügt diese ungeklammert in das rechnungsArray ein
	 */
	private void prepareList() {
		ArrayList newR = new ArrayList();
		int x = (int) getFirstKlammer().getX();
		int y = (int) getFirstKlammer().getY();
		boolean hasParams = false;
		if (x != -1 && y != -1) {
			String actOP = rechnung.get(x).toString().substring(0, rechnung.get(x).toString().length() - 1);
			if (rechnung.get(x).equals("(") || opHandler.getIDByOp(actOP) != -1) {// Falls eine Klammer gefunden wurde
				rechnung.remove(x);
				rechnung.remove(y - 1);
				for (int i = x; i < y - 1; i++) {
					newR.add(rechnung.get(i).toString());
				}
				Opperator actOp = opHandler.getOpByID(opHandler.getIDByOp(actOP));
				if (newR.contains(",") == false) {
					while (newR.size() != 1) {
						figureOut(newR);
					}
				} else {
					if (opHandler.getIDByOp(actOP) != -1) {
						if (actOp.getParams() != 1) {
							int params = actOp.getParams();
							if (newR.size() == params + (params - 1)) {//Keine Berechnung notwendig
								ArrayList<String> actParams = new ArrayList<>();
								for (int c = 0; c < newR.size(); c++) {
									if (newR.get(c).equals(",") == false) {
										actParams.add(newR.get(c).toString());
									}
								}
								newR.clear();
								newR.add(actOp.getResult(actParams.toArray()));
								hasParams = true;
							} else {
								ausgabe = "Error";
							}
						}
					}
				}
				rechnung.set(x, newR.get(0));
				if (opHandler.getIDByOp(actOP) != -1 && hasParams == false) {
					if (newR.contains(",")) {
						ausgabe = "Error";
					}
					if (actOp.getParams() < 2) {
						Double n = Double.parseDouble(rechnung.get(x).toString());
						String result = actOp.getResult(n);
						rechnung.set(x, result);
					}
				}
				for (int i = x + 1; i < y - 1; i++) {
					rechnung.remove(x + 1);
				}
			}
		}
	}

}
