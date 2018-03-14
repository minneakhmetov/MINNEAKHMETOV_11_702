package ru.itis;

import org.junit.Test;

public class AnalyzerTest {

    Analyzer analyzer = new Analyzer();

    @Test(expected = SyntaxException.class)
    public void oneLetterString() {
        String string = "A;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void oneNumberString() {
        String string = "1;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void oneLetterNumberString() {
        String string = "A1;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void twoLetters() {
        String string = "AA;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void anotherLetters() {
        String string = "vjebrk;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void assignmentTwoDots() {
        String string = "A1(;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void assignmentEqually() {
        String string = "A1:3;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorNumber() {
        String string = "A1:=-;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorLetter() {
        String string = "A1:=B;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorIdentificator() {
        String string = "A1:=B1;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorIdentificatorLetterLetter() {
        String string = "A1:=BB;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorPlus() {
        String string = "A1:=B1+;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorIdentificatorLetter() {
        String string = "A1:=B1M;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorPlusLetter() {
        String string = "A1:=B1+M;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorPlusLetterLetter() {
        String string = "A1:=B1+MM;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void identificatorPlusNumber() {
        String string = "A1:=B1+123;";
        analyzer.analyze(string);
    }

    @Test(expected = SyntaxException.class)
    public void withoutDotWithComma(){
        String string = "A1:=12";
        analyzer.analyze(string);
    }
}