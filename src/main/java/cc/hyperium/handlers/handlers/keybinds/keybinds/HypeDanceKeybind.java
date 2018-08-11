package cc.hyperium.handlers.handlers.keybinds.keybinds;

import cc.hyperium.Hyperium;
import cc.hyperium.handlers.handlers.keybinds.HyperiumBind;
import cc.hyperium.netty.NettyClient;
import cc.hyperium.netty.packet.packets.serverbound.ServerCrossDataPacket;
import cc.hyperium.utils.JsonHolder;
import cc.hyperium.utils.UUIDUtil;
import org.lwjgl.input.Keyboard;

public class HypeDanceKeybind extends HyperiumBind {
    public HypeDanceKeybind() {
        super("Do the Fortnite Hype dance", Keyboard.KEY_LBRACKET);
    }

    @Override
    public void onPress() {
        Hyperium.INSTANCE.getHandlers().getFortniteHypeDance().getStates().put(UUIDUtil.getClientUUID(), System.currentTimeMillis());
        Hyperium.INSTANCE.getHandlers().getFortniteHypeDance().startAnimation(UUIDUtil.getClientUUID());
        NettyClient client = NettyClient.getClient();
        if (client != null)
            client.write(ServerCrossDataPacket.build(new JsonHolder().put("type", "fortnite_hype_dance")));

    }
}
