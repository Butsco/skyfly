package com.droidbender.skyfly.comments;

import com.droidbender.skyfly.comments.model.Comment;
import com.droidbender.skyfly.comments.model.Person;
import java.util.Random;

public class SampleComments {

  static String[] comments = {
      "THE MAN WHO PASSES THE SENTENCE SHOULD SWING THE SWORD.", "THE THINGS I DO FOR LOVE.",
      "THE NEXT TIME YOU RAISE A HAND TO ME WILL BE THE LAST TIME YOU HAVE HANDS!", "IT'S THE FAMILY NAME THAT LIVES ON. IT'S ALL THAT LIVES ON.",
      "WHEN YOU PLAY THE GAME OF THRONES, YOU WIN OR YOU DIE.", "I LEARNED HOW TO DIE A LONG TIME AGO.",
      "WHEN DEAD MEN AND WORSE COME HUNTING … YOU THINK IT MATTERS WHO SITS ON THE IRON THRONE?",
      "THE MAD KING DID AS HE LIKED. HAS YOUR UNCLE JAIME EVER TOLD YOU WHAT HAPPENED TO HIM?", "TURN US AWAY, AND WE WILL BURN YOU FIRST.",
      "A GIRL GIVES A MAN HIS OWN NAME?", "YOUR JOY WILL TURN TO ASHES IN YOUR MOUTH.", "WE'LL COME OUT BEHIND THEM AND F--- THEM IN THEIR ARSES!",
      "NEITHER GODS NOR MEN WILL EVER COMPEL ME TO LET YOU TURN CASTERLY ROCK INTO YOUR WHOREHOUSE.",
      "I PRAYED TO THE GODS 'TAKE HIM AWAY, MAKE HIM DIE.'", "A DRAGON IS NOT A SLAVE.", "BURN THEM ALL", "CHAOS ISN'T A PIT. CHAOS IS A LADDER.",
      "YOU'LL BE F---ING YOUR OWN BRIDE WITH A WOODEN COCK.", "IF YOU EVER CALL ME SISTER AGAIN, I'LL HAVE YOU STRANGLED IN YOUR SLEEP.",
      "THE LANNISTERS SEND THEIR REGARDS."
  };

  public static Comment generateComment () {

    int index = new Random().nextInt(8) + 1;
    Comment comment = new Comment();
    comment.text = getRandomString();
    comment.person = new Person();
    comment.person.name = "person " + index;
    comment.person.url = "http://lorempixel.com/image_output/people-q-c-250-250-" + index + ".jpg";
    comment.timeout = 6000;
    return comment;
  }

  private static String getRandomString () {

    String comment = comments[new Random().nextInt(comments.length)];
    comment = comment.toLowerCase();
    comment = Character.toUpperCase(comment.charAt(0)) + comment.substring(1);
    return comment;
  }
}
