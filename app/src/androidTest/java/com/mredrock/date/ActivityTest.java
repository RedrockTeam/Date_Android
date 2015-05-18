package com.mredrock.date;

import android.test.ActivityTestCase;

import com.mredrock.date.letter.presenter.LetterActivityPresenter;
import com.mredrock.date.letter.view.LetterActivityVu;

/**
 * Created by Lecion on 5/14/15.
 */
public class ActivityTest extends ActivityTestCase{
    private LetterActivityPresenter letterActivityPresenter;
    private LetterActivityVu letterActivityVu;
    void testModel() {
        letterActivityPresenter = new LetterActivityPresenter();
        letterActivityVu = new LetterActivityVu();
        
    }
}
