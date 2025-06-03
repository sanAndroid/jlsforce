package com.github.sanandroid.jlsforce.state

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.Nullable

/**
 * Supports storing the application settings in a persistent way.
 * The [State] and [Storage] annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
    name = "com.github.sanandroid.jlsforce.settings.JlsForceState",
    storages = [Storage("JlsForcePlugin.xml")],
)
class JlsForceState : PersistentStateComponent<JlsForceState?> {

    @Nullable
    override fun getState() = this

    override fun loadState(state: JlsForceState) =
        XmlSerializerUtil.copyBean(state, this)

    // var username = ""
    var clientId = ""

    var baseUrl = ""
    var classPath: String? = null
    var packageName: String? = null

    var filterLayoutable = false
    var filterCreatable = true
    var filterCustom = false
    var filterDeletable = true
    var filterMergeable = true
    var filterReplicateable = true
    var filterRetrieveable = true
    var filterSearchable = true
    var filterUpdateable = true

    var classList = ""
    var useClassFilters: Boolean = false
    var useClassList: Boolean = true

    companion object {
        val instance: JlsForceState
            get() = ApplicationManager.getApplication().getService(JlsForceState::class.java)
    }
}
