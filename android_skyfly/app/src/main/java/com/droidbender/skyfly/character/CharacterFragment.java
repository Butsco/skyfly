package com.droidbender.skyfly.character;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.droidbender.skyfly.R;
import com.droidbender.skyfly.character.models.CharacterInfo;
import java.util.HashMap;

public class CharacterFragment extends Fragment {

  @Bind (android.R.id.background) ImageView backgroundImageView;

  @Bind (android.R.id.icon) ImageView iconImageView;

  @Bind (R.id.name) TextView nameTextView;

  @Bind (R.id.introduction) TextView introTextView;

  @Bind (R.id.bio) TextView bioTextView;

  @Bind (R.id.family1) ImageView family1Image;

  @Bind (R.id.family1_name) TextView family1Name;

  @Bind (R.id.family1_stuff) TextView family1Stuff;

  @Bind (R.id.family2) ImageView family2Image;

  @Bind (R.id.family2_name) TextView family2Name;

  @Bind (R.id.family2_stuff) TextView family2Stuff;

  @Bind (R.id.family3) ImageView family3Image;

  @Bind (R.id.family3_name) TextView family3Name;

  @Bind (R.id.family3_stuff) TextView family3Stuff;

  @Bind (R.id.sigil_name) TextView sigilName;

  @Bind (R.id.sigil) ImageView sigilImageView;

  HashMap<Float, String> timeStamp = new HashMap<>();

  private CharacterInfo characterInfo;

  private Handler handler;

  @Nullable @Override public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_character, null);
    ButterKnife.bind(this, view);

    handler = new Handler();

    timeStamp.put(5.7f, "Eddard Stark");
    timeStamp.put(9.0f, "Sansa Stark");
    timeStamp.put(16.0f, "Petyr Baelish");
    timeStamp.put(21.0f, "Joffrey Baratheon");
    timeStamp.put(25.3f, "Eddard Stark");

    return view;
  }

  @Override public void onViewCreated (View view, Bundle savedInstanceState) {

    super.onViewCreated(view, savedInstanceState);
  }

  private void fillWithCharInfo (CharacterInfo characterInfo) {

    Glide.with(this).load(Uri.parse(characterInfo.image)).asBitmap().into(iconImageView);
    Glide.with(this).load(Uri.parse(characterInfo.background)).asBitmap().into(backgroundImageView);
    nameTextView.setText(characterInfo.name);
    introTextView.setText(characterInfo.introduction);
    bioTextView.setText(characterInfo.biography);

    Glide.with(this).load(Uri.parse(characterInfo.family.get(0).image)).asBitmap().into(family1Image);
    family1Name.setText(characterInfo.family.get(0).name);
    family1Stuff.setText(characterInfo.family.get(0).relation);

    Glide.with(this).load(Uri.parse(characterInfo.family.get(1).image)).asBitmap().into(family2Image);
    family2Name.setText(characterInfo.family.get(1).name);
    family2Stuff.setText(characterInfo.family.get(1).relation);

    Glide.with(this).load(Uri.parse(characterInfo.family.get(2).image)).asBitmap().into(family3Image);
    family3Name.setText(characterInfo.family.get(2).name);
    family3Stuff.setText(characterInfo.family.get(2).relation);

    sigilName.setText(characterInfo.house.name);

    if (characterInfo.name.equals("Eddard Stark")) {
      Glide.with(this).load(R.drawable.stark).asBitmap().into(sigilImageView);
    } else if (characterInfo.name.equals("Petyr Baelish")) {
      Glide.with(this).load(R.drawable.baelish).asBitmap().into(sigilImageView);
    } else if (characterInfo.name.equals("Joffrey Baratheon")) {
      Glide.with(this).load(R.drawable.baratheon).asBitmap().into(sigilImageView);
    }
  }

  public void start () {

    handler.removeCallbacks(null);
    handler.postDelayed(new Runnable() {

      @Override public void run () {

        fillWithCharInfo(SampleCharacter.getCharacterInfo("Eddard Stark"));
      }
    }, 4900);

    handler.postDelayed(new Runnable() {

      @Override public void run () {

        fillWithCharInfo(SampleCharacter.getCharacterInfo("Sansa Stark"));
      }
    }, 8400);

    handler.postDelayed(new Runnable() {

      @Override public void run () {

        fillWithCharInfo(SampleCharacter.getCharacterInfo("Petyr Baelish"));
      }
    }, 14800);

    handler.postDelayed(new Runnable() {

      @Override public void run () {

        fillWithCharInfo(SampleCharacter.getCharacterInfo("Joffrey Baratheon"));
      }
    }, 20500);

    handler.postDelayed(new Runnable() {

      @Override public void run () {

        fillWithCharInfo(SampleCharacter.getCharacterInfo("Eddard Stark"));
      }
    }, 25100);
  }
}
