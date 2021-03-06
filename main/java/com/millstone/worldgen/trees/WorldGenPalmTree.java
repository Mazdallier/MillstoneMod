package com.millstone.worldgen.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.millstone.registry.BlockRegistry;

public class WorldGenPalmTree extends WorldGenAbstractTree{

	public WorldGenPalmTree() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		while(world.isAirBlock(x, y, z) && y > 2){
			--y;
		}
		
		Block block = world.getBlock(x, y, z);
		
		if(block != Blocks.grass && block != Blocks.dirt){
			return false;
		}
		
		else{
			
			for(int i = -2; i <= 2; i++){
				
				for(int j = -2; j <= 2; j++){
					
					if(world.isAirBlock(x + i, y - 1, z + j) && world.isAirBlock(x + i, y -2, z + j) && !world.isAirBlock(x + i, y, z + j)){
						return false;
					}
				}
			}
			
			int baseLength = 4 + rand.nextInt(4);
			//int branches = 2 + rand.nextInt(4);
			
			int h = 1;
			
			block.onPlantGrow(world, x, y -1, z, x, y, z);
			
			for(int i = 0; i < baseLength; i++){
				buildBlock(world, x, y + h, z, BlockRegistry.log, 1);
				h ++;
			}
			
//			int c = 1;
//			
//			for(int i = 0; i < branches; i++){
//				generateBranch(world, rand, x, y + h, z, c);
//				c++;
//				h+=2;
//				
//			}
			
			generateTop(world, x, y + h, z);
			return true;
		}
		
	}
	
	public void generateTop(World world, int x, int y, int z){
		
//		for(int i = -1; i < 2; i++){
//			
//			for(int j = -1; i < 2; j++){
//				buildBlock(world, x + i, y, z + j, BlockRegistry.leaf, 1);
//			}	
//		}
		
//		buildBlock(world, x, y, z, BlockRegistry.log, 1);
//		buildBlock(world, x, y + 1, z, BlockRegistry.log, 1);
//
//		buildBlock(world, x + 1, y + 1, z, BlockRegistry.leaf, 1);
//		buildBlock(world, x - 1 , y + 1, z, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 1, z + 1, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 1, z - 1, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 2, z, BlockRegistry.leaf, 1);
		
		buildBlock(world, x + 2, y - 1, z, BlockRegistry.leaf, 1);
        buildBlock(world, x - 2, y - 1, z, BlockRegistry.leaf, 1);
        buildBlock(world, x, y - 1, z + 2, BlockRegistry.leaf, 1);
        buildBlock(world, x, y - 1, z - 2, BlockRegistry.leaf, 1);

        buildBlock(world, x + 1, y, z, BlockRegistry.leaf, 1);
        buildBlock(world, x - 1, y, z, BlockRegistry.leaf, 1);
        buildBlock(world, x, y, z + 1, BlockRegistry.leaf, 1);
        buildBlock(world, x, y, z - 1, BlockRegistry.leaf, 1);
        
        buildBlock(world, x + 2, y, z + 2, BlockRegistry.leaf, 1);
        buildBlock(world, x - 2, y, z - 2, BlockRegistry.leaf, 1);
        buildBlock(world, x + 2, y, z - 2, BlockRegistry.leaf, 1);
        buildBlock(world, x - 2, y, z + 2, BlockRegistry.leaf, 1);

        buildBlock(world, x + 1, y + 1, z - 1, BlockRegistry.leaf, 1);
        buildBlock(world, x - 1, y + 1, z + 1, BlockRegistry.leaf, 1);
        buildBlock(world, x + 1, y + 1, z + 1, BlockRegistry.leaf, 1);
        buildBlock(world, x - 1, y + 1, z - 1, BlockRegistry.leaf, 1);
        buildBlock(world, x, y + 1, z, BlockRegistry.leaf, 1);

//        buildBlock(world, x + 2, y + 2, z, BlockRegistry.leaf, 1);
//        buildBlock(world, x - 2, y + 2, z, BlockRegistry.leaf, 1);
//        buildBlock(world, x, y + 2, z + 2, BlockRegistry.leaf, 1);
//        buildBlock(world, x, y + 2, z - 2, BlockRegistry.leaf, 1);

		
	}
	
//	public void generateBranch(World world, Random rand, int x, int y, int z, int p){
//		
//		for(int i = -1; i < 2; i++){
//			
//			for(int j = -1; i < 2; j++){
//				buildBlock(world, x + i, y, z + j, BlockRegistry.leaf, 1);
//			}	
//		}
//		
//		buildBlock(world, x + 1, y + 1, z, BlockRegistry.leaf, 1);
//		buildBlock(world, x - 1 , y + 1, z, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 1, z + 1, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 1, z - 1, BlockRegistry.leaf, 1);
//		buildBlock(world, x, y + 1, z, BlockRegistry.log, 1);
//		buildBlock(world, x, y, z, BlockRegistry.log, 1);
//
//	}
	
	public void buildBlock(World world, int x, int y, int z, Block block, int meta)
    {
    	if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z))
		{
    		world.setBlock(x, y, z, block, meta, 2);
		}
    }
	
}