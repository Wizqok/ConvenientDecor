package com.github.mim1q.convenientdecor.block;

import com.github.mim1q.convenientdecor.block.blockentity.WeatherVaneBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class WeatherVaneBlock extends Block implements BlockEntityProvider {
  public WeatherVaneBlock() {
    super(FabricBlockSettings.of(Material.METAL).breakInstantly().noCollision().nonOpaque());
  }

  @Nullable
  @Override
  public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new WeatherVaneBlockEntity(pos, state);
  }
}