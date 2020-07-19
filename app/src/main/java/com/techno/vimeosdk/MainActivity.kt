package com.techno.vimeosdk
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.techno.vimeosdk.listeners.VimeoPlayerReadyListener
import com.techno.vimeosdk.listeners.VimeoPlayerStateListener
import com.techno.vimeosdk.model.TextTrack
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView(1743051)

        btnPlaySelenaVideo.setOnClickListener {
            setupView(439572354)
        }

        btnPlayLimitlessChess.setOnClickListener {
            setupView(439571332)
        }

        btnPlayDefault.setOnClickListener {
            setupView(1743051)
        }
    }

    private fun setupView(strVideoID: Int) {

        lifecycle.addObserver(vimeoPlayer)

        /**
         *  Please do check the vimeoPlayer.initialize() method.
         */
        vimeoPlayer.initialize(true, strVideoID)

        //vimeoPlayer.initialize(true, {YourPrivateVideoId}, "SettingsEmbeddedUrl")
        //vimeoPlayer.initialize(true, {YourPrivateVideoId},"VideoHashKey", "SettingsEmbeddedUrl")

        vimeoPlayer.addTimeListener { second ->
            playerCurrentTimeTextView.text = getString(R.string.player_current_time, second.toString())
        }

        vimeoPlayer.addErrorListener { message, method, name -> }

        vimeoPlayer.addReadyListener(object : VimeoPlayerReadyListener {
            override fun onReady(title: String?, duration: Float, textTrackArray: Array<TextTrack>) {
            }

            override fun onInitFailed() {

            }
        })

        vimeoPlayer.addStateListener(object : VimeoPlayerStateListener {
            override fun onPlaying(duration: Float) {

            }

            override fun onPaused(seconds: Float) {

            }

            override fun onEnded(duration: Float) {

            }
        })

        volumeSeekBar.progress = 100
        volumeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var volume = progress.toFloat() / 100
                vimeoPlayer.setVolume(volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        vimeoPlayer.addVolumeListener { volume ->

        }

        playButton.setOnClickListener {
            vimeoPlayer.play()
        }

        pauseButton.setOnClickListener {
            vimeoPlayer.pause()
        }
    }
}
