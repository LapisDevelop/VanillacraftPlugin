package com.lapisdev.vanillacraft.log.login;

import static com.lapisdev.vanillacraft.VanillacraftPlugin.handle;

public class LoginModule {
    public LoginModule() {
        handle(new LoginJoinListener());
    }
}
