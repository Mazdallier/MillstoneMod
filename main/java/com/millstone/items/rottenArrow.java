package com.millstone.items;

import net.minecraft.item.Item;

import com.millstone.MillstoneMod;
import com.millstone.lib.References;

public class rottenArrow extends Item{
	
	public rottenArrow() {
		this.setUnlocalizedName("rottenArrow");
		this.setTextureName(References.MODID + ":" + "rottenArrow");
		this.setCreativeTab(MillstoneMod.tabMillstoneTools);
		this.setMaxStackSize(64);
	}

}
