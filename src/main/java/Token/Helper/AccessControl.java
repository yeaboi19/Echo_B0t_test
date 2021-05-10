package Token.Helper;

import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class AccessControl {
    public final String zukasGuildId = "795406865676763178";

    public boolean AccessControl(String authId) {
        if (authId != null) {
            if (authId.equalsIgnoreCase("322398589936730112")) {// soft id
                return true;
            } else if (authId.equalsIgnoreCase("260466498068283393")) {//heraklis id
                return true;
            } else if (authId.equalsIgnoreCase("398893725842931722")) {//bachos id
                return true;
            } else if (authId.equalsIgnoreCase("616005188829839412")) {//levanis id
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean AccessRoleControl(List<Role> roleList) {
        if (roleList != null) {
            for (int i = 0; i < roleList.size(); i++) {
                String authId = String.valueOf(roleList.get(i).getIdLong());
                if (authId.equalsIgnoreCase("799751298803040276")) {// zuka role id
                    return true;
                } else if (authId.equalsIgnoreCase("810154981498814475")) {// X role id
                    return true;
                }
            }
        }
        return false;
    }
}
