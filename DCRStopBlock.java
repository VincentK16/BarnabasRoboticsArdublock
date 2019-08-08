package com.ardublock.translator.block;

import com.ardublock.translator.Translator;

public class DCRStopBlock extends ConstBlock
{

	public DCRStopBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("RStop");
	}
}
