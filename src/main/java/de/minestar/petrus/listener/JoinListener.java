/*
 * Copyright (C) 2014 MineStar.de 
 * 
 * This file is part of Petrus.
 * 
 * Petrus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * 
 * Petrus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Petrus.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.minestar.petrus.listener;

import static de.minestar.petrus.core.PetrusCore.TEAM_MANAGER;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.minestar.petrus.common.Team;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent event) {
        Team team = TEAM_MANAGER.pendingMembersTeam(event.getPlayer());
        if (team != null) {
            TEAM_MANAGER.finishPendingMember(event.getPlayer(), team);
        }
    }
}
