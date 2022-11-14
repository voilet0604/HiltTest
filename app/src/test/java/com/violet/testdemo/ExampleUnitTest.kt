package com.violet.testdemo

import androidx.appcompat.app.AppCompatActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject

@AndroidEntryPoint
class TestMainActivity : MainActivity() {

}

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
@Config(application = HiltTestApplication::class, manifest = Config.NONE)
@LooperMode(LooperMode.Mode.PAUSED)
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @get:Rule()
    var rule = HiltAndroidRule(this)

//    private lateinit var scenario : ActivityScenario<TestMainActivity>

    @Inject
    lateinit var user: User

    @Before
    fun init() {
        rule.inject()
//        scenario = ActivityScenario.launch(TestMainActivity::class.java)
        Robolectric.buildActivity(MainActivity::class.java).create().resume().get()
    }

    @Test
    fun addition_isCorrect() {
//        scenario.onActivity {
////            it.user = User()
////            it.user.getName()
//
//        }
    }
}