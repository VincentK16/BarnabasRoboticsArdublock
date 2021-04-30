package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class zzz extends TranslatorBlock
{
    public zzz(Long blockId, Translator translator, String codePrefix,    String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

  @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
      TranslatorBlock pinBlock = this.getRequiredTranslatorBlockAtSocket(0);
      NumberBlock pinNumberBlock = (NumberBlock)pinBlock;

      String number = pinNumberBlock.toCode();
      String setupCode = " pinMode(" + number + "), INPUT_PULLUP;";
      translator.addSetupCommand(setupCode);

      TranslatorBlock buttonPress = this.getRequiredTranslatorBlockAtSocket(1);
      String press = buttonPress.toCode();

      String ret = "\tdigitalRead(" + pinBlock.toCode() + ") == " + press + " ";
      return ret;
    }

}
