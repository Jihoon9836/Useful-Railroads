package info.u_team.useful_railroads.screen;

import com.mojang.blaze3d.vertex.PoseStack;

import info.u_team.u_team_core.gui.elements.ScalableButton;
import info.u_team.u_team_core.screen.UContainerMenuScreen;
import info.u_team.useful_railroads.UsefulRailroadsMod;
import info.u_team.useful_railroads.menu.TrackBuilderMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class TrackBuilderScreen extends UContainerMenuScreen<TrackBuilderMenu> {
	
	private static final ResourceLocation BACKGROUND = new ResourceLocation(UsefulRailroadsMod.MODID, "textures/gui/track_builder.png");
	
	private final Component modeTextComponent;
	private final Component railsTextComponent;
	private final Component groundBlocksTextComponent;
	private final Component tunnelBlocksTextComponent;
	private final Component redstoneTorchesTextComponent;
	private final Component torchesTextComponent;
	private final Component fuelTextComponent;
	
	public TrackBuilderScreen(TrackBuilderMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title, BACKGROUND, 284, 296);
		backgroundWidth = backgroundHeight = 512;
		setTextLocation(8, 6, 62, imageHeight - 94);
		
		final String langKey = "container.usefulrailroads.track_builder.";
		
		modeTextComponent = Component.translatable(langKey + "mode");
		railsTextComponent = Component.translatable(langKey + "rails");
		groundBlocksTextComponent = Component.translatable(langKey + "ground_blocks");
		tunnelBlocksTextComponent = Component.translatable(langKey + "tunnel_blocks");
		redstoneTorchesTextComponent = Component.translatable(langKey + "redstone_torches");
		torchesTextComponent = Component.translatable(langKey + "torches");
		fuelTextComponent = Component.translatable(langKey + "fuel");
	}
	
	@Override
	protected void init() {
		super.init();
		
		addRenderableWidget(new ScalableButton(leftPos + 169, topPos + 16, 108, 11, Component.nullToEmpty(null), 0.7F, button -> {
			menu.getChangeModeMessage().triggerMessage();
		}) {
			
			@Override
			public Component getMessage() {
				return menu.getWrapper().getMode().getDisplayComponent();
			}
		});
	}
	
	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		super.renderLabels(poseStack, mouseX, mouseY);
		
		font.draw(poseStack, modeTextComponent, 169, 6, 0x404040);
		
		font.draw(poseStack, railsTextComponent, 8, 20, 0x404040);
		font.draw(poseStack, groundBlocksTextComponent, 8, 52, 0x404040);
		font.draw(poseStack, tunnelBlocksTextComponent, 8, 102, 0x404040);
		font.draw(poseStack, redstoneTorchesTextComponent, 8, 170, 0x404040);
		font.draw(poseStack, torchesTextComponent, 116, 170, 0x404040);
		
		final Component fuelComponent = fuelTextComponent.plainCopy().append(": ").append(Component.literal(Integer.toString(menu.getWrapper().getFuel())).withStyle(ChatFormatting.DARK_AQUA));
		
		font.draw(poseStack, fuelComponent, imageWidth - font.width(fuelComponent) - 6, 170, 0x404040);
	}
	
}
