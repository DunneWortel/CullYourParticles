 package tfar.cullparticles;
 
 import com.mojang.blaze3d.vertex.IVertexBuilder;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.particle.Particle;
 import net.minecraft.client.renderer.ActiveRenderInfo;
 import net.minecraftforge.fml.common.Mod;
 
 @Mod("cullparticles")
 public class MixinHooks {
/* 11 */   public static final Minecraft mc = Minecraft.getInstance();
   static final String MODID = "cullparticles";
   
   public static void cullParticles(Particle particle, IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
/* 15 */     if (((FrustumCapture)mc.levelRenderer).getFrustum().isVisible(particle.getBoundingBox()))
/* 16 */       particle.render(buffer, renderInfo, partialTicks);
   }
 }