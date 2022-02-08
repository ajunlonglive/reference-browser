/* This Source Code Form is subject to the terms of the Mozilla Public
* License, v. 2.0. If a copy of the MPL was not distributed with this
* file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.reference.browser.ui.robots

import android.util.Log
import androidx.test.uiautomator.UiSelector
import junit.framework.Assert.assertTrue
import org.mozilla.reference.browser.helpers.TestAssetHelper.waitingTime
import org.mozilla.reference.browser.helpers.TestHelper.packageName

/**
 * Implementation of Robot Pattern for Synced Tabs sub menu.
 */
class SyncedTabsRobot {

    fun verifyNotSignedInSyncTabsView() = assertNotSignedInSyncTabsView()

    class Transition {
        fun syncedTabs(interact: SyncedTabsRobot.() -> Unit): SyncedTabsRobot.Transition {
            SyncedTabsRobot().interact()
            return SyncedTabsRobot.Transition()
        }
    }

    private fun assertNotSignedInSyncTabsView() {
        assertTrue(
            mDevice.findObject(
                UiSelector()
                    .resourceId("$packageName:id/synced_tabs_status")
                    .textContains("Connect with a Firefox Account.")

            ).waitForExists(waitingTime)
        )
        Log.i("Andi", "Verified synced tabs")
    }
}
