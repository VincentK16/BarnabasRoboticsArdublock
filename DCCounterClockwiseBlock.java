package com.ardublock.translator.block;

import com.ardublock.translator.Translator;

public class DCCounterClockwiseBlock extends ConstBlock
{

	public DCCounterClockwiseBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("CCW");
	}
}
