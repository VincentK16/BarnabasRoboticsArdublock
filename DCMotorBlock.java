package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DCMotorBlock extends TranslatorBlock
{
    public DCMotorBlock(Long blockId, Translator translator, String codePrefix,    String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

  @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
      TranslatorBlock pinBlock0 = this.getRequiredTranslatorBlockAtSocket(0);
      NumberBlock pinNumberBlock0 = (NumberBlock)pinBlock0;

      String pinNumber0 = pinNumberBlock0.toCode();
      translator.addSetupCommand("pinMode(" + pinNumber0 + ", OUTPUT);");

      TranslatorBlock pinBlock1 = this.getRequiredTranslatorBlockAtSocket(1);
      NumberBlock pinNumberBlock1 = (NumberBlock)pinBlock1;

      String pinNumber1 = pinNumberBlock1.toCode();
      translator.addSetupCommand("pinMode(" + pinNumber1 + ", OUTPUT);");

  		TranslatorBlock rotation = this.getRequiredTranslatorBlockAtSocket(2);

      String pinControl = rotation.toCode();

      String ret;

      if (pinControl.equals("CW") == true)
      {
        ret = "\tdigitalWrite(" + pinBlock0.toCode() + ", HIGH); \n\tdigitalWrite(" + pinBlock1.toCode() + ", LOW); \n";
      }
      else if (pinControl.equals("CCW") == true)
      {
        ret = "\tdigitalWrite(" + pinBlock0.toCode() + ", LOW); \n\tdigitalWrite(" + pinBlock1.toCode() + ", HIGH); \n";
      }
      else if (pinControl.equals("IStop") == true)
      {
        ret = "\tdigitalWrite(" + pinBlock0.toCode() + ", HIGH); \n\tdigitalWrite(" + pinBlock1.toCode() + ", HIGH); \n";
      }
      else
      {
        ret = "\tdigitalWrite(" + pinBlock0.toCode() + ", LOW); \n\tdigitalWrite(" + pinBlock1.toCode() + ", LOW); \n";
      }

      return ret;
    }

}
