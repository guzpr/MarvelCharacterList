package com.aegishield.prase.belajarandroid;

import android.os.Parcel;
import android.os.Parcelable;

public class Heroes implements Parcelable  {
    private String name, realName, photo,affiliation,power,logo;

    protected Heroes(Parcel in) {
        name = in.readString();
        realName = in.readString();
        photo = in.readString();
        affiliation = in.readString();
        power = in.readString();
        logo = in.readString();
    }

    public static final Creator<Heroes> CREATOR = new Creator<Heroes>() {
        @Override
        public Heroes createFromParcel(Parcel in) {
            return new Heroes(in);
        }

        @Override
        public Heroes[] newArray(int size) {
            return new Heroes[size];
        }
    };

    public Heroes(String name, String realName, String photo, String affiliation, String power,
                  String logo) {
        this.name = name;
        this.realName = realName;
        this.photo = photo;
        this.affiliation = affiliation;
        this.power = power;
        this.logo = logo;
    }

    public Heroes(){}

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public static Creator<Heroes> getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.realName);
        dest.writeString(this.photo);
        dest.writeString(this.affiliation);
        dest.writeString(this.power);
    }
}
