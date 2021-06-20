package com.crushtech.esccommandwrapper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.crushtech.esccommandwrapper.wrapper.EscCommandWrapper;
import com.gprinter.command.EscCommand;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a bluetooth class, scan and use this pseudo code to test
        EscCommandWrapper wrapper = new EscCommandWrapper();
        wrapper.addLineSpacing((byte) 2)
                .justifyText(EscCommand.JUSTIFICATION.LEFT)
                .enableFontType(EscCommand.FONT.FONTA)
                .addText("打印时间:06-15 18:21:52.880\n")
                .addPrintAndLineFeed()
                .enableAllTextModesExceptUnderLine(EscCommand.FONT.FONTB)
                .justifyText(EscCommand.JUSTIFICATION.CENTER)
                .addText("【总单】吧台\n")
                .addPrintAndLineFeed()
                .justifyText(EscCommand.JUSTIFICATION.LEFT)
                .disableAllTextModes()
                .addText("桌号:")
                .enableAllTextModesExceptUnderLine(EscCommand.FONT.FONTA)
                .addText("04")
                .addHorAndVertMotionUnits((byte) 7, (byte) 0)
                .setTextAbsPos((short) 17)
                .disableAllTextModes()
                .addText("人数:\n")
                .addText("单号:Wm102734165373897786\n")
                .addText("日期:2021-06-07 16:24:23\n")
                .addText("菜名")
                .addHorAndVertMotionUnits((byte) 7, (byte) 0)
                .setTextAbsPos((short) 15)
                .addText("数量")
                .setTextAbsPos((short) 20)
                .addText("单位")
                .addStrokes();

        ArrayList<OrderItem> arrayList = new ArrayList<>();
        arrayList.add(new OrderItem(2, "伏特加红牛桶[新]", "份", "冰"));
        arrayList.add(new OrderItem(1, "伏特加红牛桶", "份", "冰"));
        arrayList.add(new OrderItem(20, "伏特加红牛", "份", "冰"));
        arrayList.add(new OrderItem(5, "伏特加红", "份", "冰"));
        arrayList.add(new OrderItem(11, "伏特加", "份", "冰"));
        arrayList.add(new OrderItem(9, "伏特", "份", "冰"));
        for (int i = 0; i < arrayList.size(); i++) {

            wrapper.enableTextDoubleHeight()
                    .addText(arrayList.get(i).getItemName())
                    .addHorAndVertMotionUnits((byte) 7, (byte) 0)
                    .setTextAbsPos((short) 16)
                    .disableDoubleHeight()
                    .addText(String.valueOf(arrayList.get(i).getQty()))
                    .setTextAbsPos((short) 20)
                    .addText(arrayList.get(i).getUnit()+"\n")
                    .addText("口味:")
                    .enableTextDoubleHeight()
                    .addText(arrayList.get(i).getTaste() + "\n")
                    .disableDoubleHeight();
        }
        wrapper.addStrokes()
                .addLineSpacing((byte) 4)
                .addUserCommand();


        Vector<Byte> datas = wrapper.getCommand();
    }
}