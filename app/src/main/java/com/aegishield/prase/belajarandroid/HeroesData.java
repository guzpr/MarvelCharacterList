package com.aegishield.prase.belajarandroid;

import java.util.ArrayList;

public class HeroesData {

    public static String[][] data = new String[][]{
            {"Iron Man", "Anthony Edward \"Tony\" Stark", "https://vignette.wikia.nocookie" +
                    ".net/marveldatabase/images/e/e7/Iron_Man_Vol_4_6_Textless" +
                    ".jpg/revision/latest?cb=20100309183023","Avengers,Stark Industries",
                    "Supersuits","http://www.stickpng.com/assets/images/5842a4f5a6515b1e0ad75af6.png"},
            {"Captain Marvel", "Carol Susan Jane Danvers", "https://vignette.wikia.nocookie.net/marveldatabase/images/0/0a/Carol_Danvers_%28Earth-616%29_from_Life_of_Captain_Marvel_Vol_2_4_Bartel_Variant_cover.jpg/revision/latest?cb=20180726214728","Avengers",
                    "Superhuman Strength,Flight,Energy Manipulation","http://www.stickpng.com/assets/images/5842a4f5a6515b1e0ad75af6.png"},
            {"Spider-Man", "Peter Benjamin Parker", "https://vignette.wikia.nocookie.net/marveldatabase/images/f/f1/Amazing_Spider-Man_Vol_3_1_Granov_Variant_Textless.jpg/revision/latest?cb=20140316144029","Avengers",
                    "Wall-Crawling,Spider Sense","http://www.stickpng.com/assets/images/5842a4f5a6515b1e0ad75af6.png"},
            {"Wolverine", "James Howlett", "https://vignette.wikia.nocookie" +
                    ".net/marveldatabase/images/2/2b/Return_of_Wolverine_Vol_1_2_Dell" +
                    "%27Otto_Variant_Textless.jpg/revision/latest?cb=20190320201036","X-Men",
                    "Regenative,Superhuman Strength, Adamantium Claw","https://banner2.kisspng.com/20180602/rqh/kisspng-professor-x-storm-x-men-logo-cabin-5b12dd414e3510.1297023415279629453204.jpg"},
            {" Captain America", "Steven \"Steve\" Grant Rogers", "https://vignette.wikia.nocookie.net/marveldatabase/images/b/b1/Captain_America_Vol_6_2_Textless.jpg/revision/latest?cb=20110719042719","Avengers",
                    "Peak Human Strength","http://www.stickpng" +
                    ".com/assets/images/5842a4f5a6515b1e0ad75af6.png","http://www.stickpng.com/assets/images/5842a4f5a6515b1e0ad75af6.png"},
            {" Thor", "Thor Odinson", "https://vignette.wikia.nocookie.net/marveldatabase/images/b/b0/Thor_Vol_5_1_Textless.jpg/revision/latest?cb=20190114213830","Asgardians , Avengers",
                    "Godlike Strength , Mjolnir","http://www.stickpng" +
                    ".com/assets/images/5842a4f5a6515b1e0ad75af6.png"},
            {" Human Torch", "Jonathan Storm", "https://vignette.wikia.nocookie" +
                    ".net/marveldatabase/images/8/88" +
                    "/Fantastic_Four_Vol_6_1_Human_Torch_Variant_Textless" +
                    ".jpg/revision/latest?cb=20180523100956","Fantastic Four",
                    "Pyrogenesis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Fantastic_Four_logo_%28blue_and_white%29.svg/283px-Fantastic_Four_logo_%28blue_and_white%29.svg.png"},




    };

    public static ArrayList<Heroes> getListData(){
        Heroes hero = null;
        ArrayList<Heroes> list = new ArrayList<>();
        for (String[] data : data) {
            hero = new Heroes();
            hero.setName(data[0]);
            hero.setRealName(data[1]);
            hero.setPhoto(data[2]);
            hero.setAffiliation(data[3]);
            hero.setPower(data[4]);
            hero.setLogo(data[5]);
            list.add(hero);
        }

        return list;
    }

}
