package com.droidbender.skyfly.character;

import com.droidbender.skyfly.character.models.CharacterInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class SampleCharacter {

  public static String jsons = "{\n"
      + "  \"Eddard Stark\": {\n"
      + "    \"name\": \"Eddard Stark\",\n"
      + "    \"image\": \"http://vignette2.wikia.nocookie.net/gameofthrones/images/9/9c/EddardStark.jpg\",\n"
      + "    \"background\": \"http://d.ibtimes.co.uk/en/full/1375984/ned-stark-game-thrones-season-1.jpg\",\n"
      + "    \"title\": \"Hand of the King\",\n"
      + "    \"house\": {\n"
      + "      \"name\": \"House Stark\",\n"
      + "      \"image\": \"https://addons.opera.com/media/image-cache/themes/35/40935/1.0-rev1/images/75bd608a-c8fc-45ce-9ed5-5cb88dc9f56b_details_big.jpe\"\n"
      + "    },\n"
      + "    \"family\": [\n"
      + "      {\n"
      + "        \"name\": \"Catelyn Stark\",\n"
      + "        \"relation\": \"wife\",\n"
      + "        \"image\": \"http://i.lv3.hbo.com/assets/images/series/game-of-thrones/character/s5/catelyn-stark-1920.jpg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Sansa Stark\",\n"
      + "        \"relation\": \"daughter\",\n"
      + "        \"image\": \"http://images6.fanpop.com/image/photos/34100000/Sansa-Stark-sansa-stark-34183931-1920-1080.jpg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Jon Snow\",\n"
      + "        \"relation\": \"bastard son\",\n"
      + "        \"image\": \"http://images-cdn.moviepilot.com/images/c_fill,h_720,w_1280/t_mp_quality/qgqpal5akpm621tdsmlt/if-this-theory-s-true-then-jon-snow-is-definitely-dead-607536.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"religion\": \"Old Gods of the Forest\",\n"
      + "    \"quote\": \"The man who passes the sentence should swing the sword\",\n"
      + "    \"introduction\": \"Eddard Stark is the head of House Stark and Lord Paramount of the North. The North is one of the constituent regions of the Seven Kingdoms and House Stark is one of the Great Houses of the realm. House Stark rule the region from their seat of Winterfell and Eddard also holds the title Lord of Winterfell. In addition, he is the Warden of the North\"\n"
      + "  },\n"
      + "\n"
      + "  \"Sansa Stark\": {\n"
      + "    \"name\": \"Sansa Stark\",\n"
      + "    \"image\": \"http://images6.fanpop.com/image/photos/34100000/Sansa-Stark-sansa-stark-34183931-1920-1080.jpg\",\n"
      + "    \"background\": \"http://media.vanityfair.com/photos/5631ad02535004464745624c/master/w_900,c_limit/sansa-stark-season-6.jpg\",\n"
      + "    \"title\": \"Lady of Winterfell\",\n"
      + "    \"house\": {\n"
      + "      \"name\": \"House Stark\",\n"
      + "      \"image\": \"https://addons.opera.com/media/image-cache/themes/35/40935/1.0-rev1/images/75bd608a-c8fc-45ce-9ed5-5cb88dc9f56b_details_big.jpe\"\n"
      + "    },\n"
      + "    \"family\": [\n"
      + "      {\n"
      + "        \"name\": \"Catelyn Stark\",\n"
      + "        \"relation\": \"mother\",\n"
      + "        \"image\": \"http://i.lv3.hbo.com/assets/images/series/game-of-thrones/character/s5/catelyn-stark-1920.jpg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Eddard Stark\",\n"
      + "        \"relation\": \"father\",\n"
      + "        \"image\": \"http://vignette2.wikia.nocookie.net/gameofthrones/images/9/9c/EddardStark.jpg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Jon Snow\",\n"
      + "        \"relation\": \"brother\",\n"
      + "        \"image\": \"http://images-cdn.moviepilot.com/images/c_fill,h_720,w_1280/t_mp_quality/qgqpal5akpm621tdsmlt/if-this-theory-s-true-then-jon-snow-is-definitely-dead-607536.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"religion\": \"Old Gods of the Forest\",\n"
      + "    \"quote\": \"There is no honor in tricks.\",\n"
      + "    \"introduction\": \"Sansa Stark is the eldest daughter and second child of Lady Catelyn and Lord Eddard Stark. Eddard is the head of House Stark and Lord Paramount of the North. The North is one of the constituent regions of the Seven Kingdoms and House Stark is one of the Great Houses of the realm. House Stark rules the region from their seat of Winterfell and Eddard also holds the titles of Lord of Winterfell and the Warden of the North to King Robert Baratheon.\"\n"
      + "  },\n"
      + "\n"
      + "  \"Petyr Baelish\": {\n"
      + "    \"name\": \"Petyr Baelish\",\n"
      + "    \"image\": \"http://vignette2.wikia.nocookie.net/game-of-thrones-le-trone-de-fer/images/e/e7/Petyr-Baelish-lord-petyr-baelish-23559640-500-300.png/revision/latest?cb=20141217182258&path-prefix=fr\",\n"
      + "    \"background\": \"https://www.bloomforth.com/blog/wp-content/uploads/2015/06/Littlefinger.jpg\",\n"
      + "    \"title\": \"Master of Coin\",\n"
      + "    \"house\": {\n"
      + "      \"name\": \"House Baelish\",\n"
      + "      \"image\": \"http://img3.wikia.nocookie.net/__cb20150226135222/gameofthrones/images/9/9e/Baelish_sig.png\"\n"
      + "    },\n"
      + "    \"family\": [\n"
      + "      {\n"
      + "        \"name\": \"Bran Stark\",\n"
      + "        \"relation\": \"nephew\",\n"
      + "        \"image\": \"http://images5.fanpop.com/image/photos/29500000/Bran-Stark-bran-stark-29540248-800-450.png\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Sansa Stark\",\n"
      + "        \"relation\": \"niece\",\n"
      + "        \"image\": \"http://images6.fanpop.com/image/photos/34100000/Sansa-Stark-sansa-stark-34183931-1920-1080.jpg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Arya Stark\",\n"
      + "        \"relation\": \"niece\",\n"
      + "        \"image\": \"http://images.tvfanatic.com/iu/v1371229251/arya-stark-image.png\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"quote\": \"Those who have the most power have the least grace.\",\n"
      + "    \"introduction\": \"Petyr Baelish is the head of House Baelish, and the lord of an extremely minor holding, so small it has neither name nor maester, located in a small area within the Fingers, a coastal region in the northeastern shores of the Vale of Arryn. He is currently House Baelish's only living member.\"\n"
      + "  },\n"
      + "\n"
      + "  \"Joffrey Baratheon\": {\n"
      + "    \"name\": \"Joffrey Baratheon\",\n"
      + "    \"image\": \"http://gameofthrones.aarongoldsman.com/wp-content/uploads/2014/04/joffrey-10241.jpg\",\n"
      + "    \"background\": \"http://www.asset1.net/tv/pictures/show/game-of-thrones/Game-Of-Thrones-Joffrey-9-16x9-1.jpg\",\n"
      + "    \"title\": \"Lord of the Seven Kingdoms\",\n"
      + "    \"house\": {\n"
      + "      \"name\": \"House Baratheon\",\n"
      + "      \"image\": \"http://pre13.deviantart.net/c100/th/pre/i/2012/155/7/9/baratheon_sigil_by_hodryronja-d527ygi.jpg\"\n"
      + "    },\n"
      + "    \"family\": [\n"
      + "      {\n"
      + "        \"name\": \"Cersei Lannister\",\n"
      + "        \"relation\": \"mother\",\n"
      + "        \"image\": \"https://pbs.twimg.com/profile_images/378800000769453762/8fbe7ec07f238b8a91fa3962235c5ef2.jpeg\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Robert Baratheon\",\n"
      + "        \"relation\": \"father\",\n"
      + "        \"image\": \"http://vignette1.wikia.nocookie.net/hieloyfuego/images/e/ee/Robert_Baratheon_HBO.JPG/revision/latest?cb=20120124224134\"\n"
      + "      },\n"
      + "      {\n"
      + "        \"name\": \"Tyrion Lannister\",\n"
      + "        \"relation\": \"uncle\",\n"
      + "        \"image\": \"http://images.latintimes.com/sites/latintimes.com/files/2014/02/27/tyrion-lannister-1024.jpg\"\n"
      + "      }\n"
      + "    ],\n"
      + "    \"quote\": \"The king can do as he likes!\",\n"
      + "    \"introduction\": \"Joffrey is believed to be the oldest son and heir of King Robert Baratheon and Queen Cersei Lannister, both of whom entered into a political marriage alliance after Robert took the throne by force from the Mad King Aerys II Targaryen. In reality, his father is Jaime Lannister, the queen's brother and the Lord Commander of the Kingsguard. He has a younger sister, Myrcella, and a younger brother, Tommen , both whom are also the product of Jaime and Cersei's incest. Their sole biological grandparents, Tywin and Joanna Lannister, were also apparently first cousins.\"\n"
      + "  }\n"
      + "\n"
      + "}";

  private static HashMap<String, CharacterInfo> info;

  public static CharacterInfo getCharacterInfo (String key) {

    if (info == null) {
      info = new Gson().fromJson(jsons, new TypeToken<HashMap<String, CharacterInfo>>() {}.getType());
    }
    return info.get(key);
  }
}