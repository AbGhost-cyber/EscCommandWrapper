package com.crushtech.esccommandwrapper.wrapper;


import com.gprinter.command.EscCommand;

import java.util.Vector;

/**
 *
 *
 * @author UDO ABUNDANCE
 *         Date: 2021/6/17
 *         Class description: a wrapper class around esc commands for printers
 */

public class EscCommandWrapper {
    private final EscCommand escCommand = new EscCommand();
    private EscCommand.FONT font = EscCommand.FONT.FONTA;
    private EscCommand.ENABLE emphasized = EscCommand.ENABLE.OFF;
    private EscCommand.ENABLE doubleHeight = EscCommand.ENABLE.OFF;
    private EscCommand.ENABLE doubleWidth = EscCommand.ENABLE.OFF;
    private EscCommand.ENABLE underLine = EscCommand.ENABLE.OFF;

    public EscCommandWrapper() {
        escCommand.addInitializePrinter();
    }

    private void setDoubleHeight(EscCommand.ENABLE doubleHeight) {
        this.doubleHeight = doubleHeight;
    }

    private void setDoubleWidth(EscCommand.ENABLE doubleWidth) {
        this.doubleWidth = doubleWidth;
    }

    private void setEmphasized(EscCommand.ENABLE emphasized) {
        this.emphasized = emphasized;
    }

    private void setFont(EscCommand.FONT font) {
        this.font = font;
    }

    private void setUnderLine(EscCommand.ENABLE underLine) {
        this.underLine = underLine;
    }

    public EscCommand.FONT getFont() {
        return font;
    }

    public EscCommand.ENABLE getEmphasized() {
        return emphasized;
    }

    public EscCommand.ENABLE getDoubleHeight() {
        return doubleHeight;
    }

    public EscCommand.ENABLE getDoubleWidth() {
        return doubleWidth;
    }

    public EscCommand.ENABLE getUnderLine() {
        return underLine;
    }


    public EscCommandWrapper enableDoubleWidth() {
        this.setDoubleWidth(EscCommand.ENABLE.ON);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper disableDoubleWidth() {
        this.setDoubleWidth(EscCommand.ENABLE.OFF);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper enableTextDoubleHeight() {
        this.setDoubleHeight(EscCommand.ENABLE.ON);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper disableDoubleHeight() {
        this.setDoubleHeight(EscCommand.ENABLE.OFF);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper enableTextEmphasized() {
        this.setEmphasized(EscCommand.ENABLE.ON);
        escCommand.addTurnEmphasizedModeOnOrOff(EscCommand.ENABLE.ON);
        return this;
    }

    public EscCommandWrapper disableEmphasized() {
        this.setEmphasized(EscCommand.ENABLE.OFF);
        escCommand.addTurnEmphasizedModeOnOrOff(EscCommand.ENABLE.OFF);
        return this;
    }

    public EscCommandWrapper enableUnderline() {
        this.setUnderLine(EscCommand.ENABLE.ON);
        escCommand.addTurnUnderlineModeOnOrOff(EscCommand.UNDERLINE_MODE.UNDERLINE_1DOT);
        return this;
    }

    public EscCommandWrapper disableUnderLine() {
        this.setUnderLine(EscCommand.ENABLE.OFF);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }


    public EscCommandWrapper justifyText(EscCommand.JUSTIFICATION js) {
        escCommand.addSelectJustification(js);
        return this;
    }

    public EscCommandWrapper enableFontType(EscCommand.FONT ft) {
        setFont(ft);
        escCommand.addSelectCharacterFont(ft);
        return this;
    }

    public EscCommandWrapper addStrokes() {
        escCommand.addText("------------------------------------------------\n");
        return this;
    }

    public EscCommandWrapper addHorAndVertMotionUnits(byte x, byte y) {
        escCommand.addSetHorAndVerMotionUnits(x, y);
        return this;
    }

    public EscCommandWrapper setTextAbsPos(short pos) {
        escCommand.addSetAbsolutePrintPosition(pos);
        return this;
    }

    public EscCommandWrapper addText(String text) {
        escCommand.addText(text);
        return this;
    }

    public EscCommandWrapper addLineSpacing(byte spacing) {
        escCommand.addPrintAndFeedLines(spacing);
        return this;
    }

    public EscCommandWrapper addPrintAndLineFeed() {
        escCommand.addPrintAndLineFeed();
        return this;
    }

    public EscCommandWrapper disableAllTextModes() {
        this.setUnderLine(EscCommand.ENABLE.OFF);
        this.setEmphasized(EscCommand.ENABLE.OFF);
        this.setFont(EscCommand.FONT.FONTA);
        this.setDoubleHeight(EscCommand.ENABLE.OFF);
        this.setDoubleWidth(EscCommand.ENABLE.OFF);
        this.setUnderLine(EscCommand.ENABLE.OFF);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper enableAllTextModes() {
        this.setUnderLine(EscCommand.ENABLE.ON);
        this.setEmphasized(EscCommand.ENABLE.ON);
        this.setFont(EscCommand.FONT.FONTB);
        this.setDoubleHeight(EscCommand.ENABLE.ON);
        this.setDoubleWidth(EscCommand.ENABLE.ON);
        this.setUnderLine(EscCommand.ENABLE.ON);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }

    public EscCommandWrapper enableAllTextModesExceptUnderLine(EscCommand.FONT ft) {
        this.setFont(ft);
        this.setUnderLine(EscCommand.ENABLE.OFF);
        this.setDoubleHeight(EscCommand.ENABLE.ON);
        this.setEmphasized(EscCommand.ENABLE.ON);
        this.setDoubleWidth(EscCommand.ENABLE.ON);
        escCommand.addSelectPrintModes(getFont(), getEmphasized(), getDoubleHeight(), getDoubleWidth(), getUnderLine());
        return this;
    }


    public void addUserCommand() {
        byte[] bytes = {29, 114, 1};
        escCommand.addUserCommand(bytes);
    }

    public Vector<Byte> getCommand() {
        return escCommand.getCommand();
    }
}
