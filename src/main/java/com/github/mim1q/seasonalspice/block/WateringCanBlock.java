package com.github.mim1q.seasonalspice.block;

import com.github.mim1q.seasonalspice.block.blockentity.WateringCanBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class WateringCanBlock extends Block implements BlockEntityProvider {
  public static final VoxelShape SHAPE = createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
  public static final BooleanProperty FULL = BooleanProperty.of("full");

  public WateringCanBlock(Settings settings) {
    super(settings);
    this.setDefaultState(super.getDefaultState().with(FULL, false));
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new WateringCanBlockEntity(pos, state);
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    super.appendProperties(builder);
    builder.add(FULL);
  }

  @Override
  @SuppressWarnings("deprecation")
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return SHAPE;
  }
}