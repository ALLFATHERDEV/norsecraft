package com.norsecraft.common.block;

import com.norsecraft.NorseCraftMod;
import com.norsecraft.common.util.VoxelShapeGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ChairBlock extends BaseDirectionalBlock {

    public ChairBlock(Settings settings, VoxelShapeGroup group) {
        super(settings, group);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        NorseCraftMod.LOGGER.info("Sitting...");
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(group == null)
            return super.getOutlineShape(state, world, pos, context);
        return switch (state.get(FACING)) {
            case EAST -> group.west;
            case WEST -> group.east;
            case SOUTH -> group.north;
            default -> group.south;
        };
    }
}
