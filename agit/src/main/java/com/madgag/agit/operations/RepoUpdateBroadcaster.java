/*
 * Copyright (c) 2011, 2012 Roberto Tyley
 *
 * This file is part of 'Agit' - an Android Git client.
 *
 * Agit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Agit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/ .
 */

package com.madgag.agit.operations;


import static com.madgag.agit.GitIntents.broadcastIntentForRepoStateChange;
import android.app.Application;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.madgag.agit.db.ReposDataSource;

import java.io.File;

public class RepoUpdateBroadcaster {

    @Inject
    Application context;
    @Inject
    @Named("gitdir")
    File gitdir;

    @Inject
    ReposDataSource reposDataSource;

    public void broadcastUpdate() {
        reposDataSource.registerRepo(gitdir);
        context.sendBroadcast(broadcastIntentForRepoStateChange(gitdir));
    }
}
