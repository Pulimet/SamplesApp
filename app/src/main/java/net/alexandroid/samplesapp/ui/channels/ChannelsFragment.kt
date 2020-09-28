package net.alexandroid.samplesapp.ui.channels

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import net.alexandroid.samplesapp.R
import net.alexandroid.samplesapp.utils.BaseFragment
import net.alexandroid.utils.mylogkt.logD


class ChannelsFragment : BaseFragment(R.layout.fragment_channels) {

    // https://medium.com/swlh/kotlin-coroutines-in-android-channel-fb9b3b65e0b
    // RENDEZVOUS - default, no buffer
    // BUFFERED - 64
    // UNLIMITED - Int.UNLIMITED
    // CONFLATED - The element in the conflated channel will be replaced by the latest element.
    //             So the channel.send() will never be suspended and the channel.receive() will always get the latest element.
    private val channel1 = Channel<Int>(Channel.BUFFERED)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstExample()
    }

    private fun firstExample() {
        // Coroutine 1
        lifecycleScope.launch {
            (1..5).forEach{
                channel1.send(it)
            }
            channel1.close()
        }

        // Coroutine 2
        lifecycleScope.launch {
            // Alternatively, use "Channel.consumeEach()".
            for(it in channel1) {
                logD("Received from channel $it")
            }
        }
    }
}