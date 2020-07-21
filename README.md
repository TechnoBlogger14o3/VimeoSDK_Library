# Playing Video of Vimeo
Vimeo is a video hosting, sharing, and services platform headquartered in New York City. Vimeo operates on an ad-free basis, and instead derives revenue by providing subscription plans for video content producers and offering software as a service (SaaS) with video creation, editing, and broadcasting tools, enterprise software solutions, as well as the means for video professionals to connect with clients and other professionals. Vimeo focuses on the delivery of high-definition video across a range of devices.

# Steps to play the Vimeo Video
- Create an account on Vimeo.
- Upload some videos.
- Copy the App Key and other information in your app.
- These keys will be useful if you want to keep your Video private or restricted to some Users.
- Once you upload the Video, you will see there is unique Video Id generated for every Video.
- We will use that Video ID to play the Video in our app.

```
setupView(1743051) // I'm hardcoding the Video ID.
```

```
 private fun setupView(strVideoID: Int) {
        lifecycle.addObserver(vimeoPlayer)
        vimeoPlayer.initialize(true, strVideoID)
        vimeoPlayer.addTimeListener { second ->
            playerCurrentTimeTextView.text = getString(R.string.player_current_time, second.toString())
        }
        vimeoPlayer.addErrorListener { message, method, name -> }
        vimeoPlayer.addReadyListener(object : VimeoPlayerReadyListener {
            override fun onReady(title: String?, duration: Float, textTrackArray: Array<TextTrack>) {}
            override fun onInitFailed() {}
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
                val volume = progress.toFloat() / 100
                vimeoPlayer.setVolume(volume)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        vimeoPlayer.addVolumeListener {

        }

        playButton.setOnClickListener {
            vimeoPlayer.play()
        }

        pauseButton.setOnClickListener {
            vimeoPlayer.pause()
        }
    }
```
- Below is the xml file
```
     <com.techno.vimeosdk.view.VimeoPlayerView
        android:id="@+id/vimeoPlayer"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        app:autoPlay="false"
        app:backgroundColor="#00FFFF"
        app:loop="false"
        app:muted="false"
        app:quality="auto"
        app:showFullscreenOption="false"
        app:showMenuOption="false"
        app:showOriginalControls="false"
        app:showTitle="true"
        app:topicColor="#FFFF00" />
```
