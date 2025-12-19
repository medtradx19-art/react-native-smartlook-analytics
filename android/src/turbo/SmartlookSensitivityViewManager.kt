package com.smartlook.reactnative

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.SmartlookSensitiveViewManagerInterface
import com.facebook.react.viewmanagers.SmartlookSensitiveViewManagerDelegate
import com.facebook.react.bridge.ReadableArray

@ReactModule(name = SmartlookSensitiveViewManagerImpl.NAME)
class SmartlookSensitiveViewManager(reactContext: ReactApplicationContext) : ViewGroupManager<SmartlookSensitiveView>(),
    SmartlookSensitiveViewManagerInterface<SmartlookSensitiveView> {
    private val delegate: ViewManagerDelegate<SmartlookSensitiveView>

    init {
        delegate = SmartlookSensitiveViewManagerDelegate(this)
    }

    override fun getDelegate(): ViewManagerDelegate<SmartlookSensitiveView> = delegate

    override fun getName(): String {
        return SmartlookSensitiveViewManagerImpl.NAME;
    }

    override fun createViewInstance(context: ThemedReactContext): SmartlookSensitiveView {
        return SmartlookSensitiveViewManagerImpl.createViewInstance(context)
    }

    @ReactProp(name = "isSensitive")
    override fun setIsSensitive(view: SmartlookSensitiveView, isSensitive: Boolean) {
        SmartlookSensitiveViewManagerImpl.setIsSensitive(view, isSensitive)
    }

    override fun changeIsViewSensitive(view: SmartlookSensitiveView, isSensitive: Boolean) {
        SmartlookSensitiveViewManagerImpl.setIsSensitive(view, isSensitive)
    }

 override fun receiveCommand(
  view: SmartlookSensitiveView,
  commandId: String?,
  args: ReadableArray?
) {
  if (commandId == null) return
  delegate.receiveCommand(view, commandId, args)
}
}
