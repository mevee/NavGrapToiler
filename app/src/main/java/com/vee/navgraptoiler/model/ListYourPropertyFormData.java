package com.vee.navgraptoiler.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ListYourPropertyFormData implements Parcelable {

    private String listingType;
    private String propertyType;
    private String noOffRooms;
    private String address;
    private String state;
    private String city;
    private String mState;
    private String zipCode;
    private String note;

    private List<String> imagesSelectedPath;

    public ListYourPropertyFormData() {
    }

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getNoOffRooms() {
        return noOffRooms;
    }

    public void setNoOffRooms(String noOffRooms) {
        this.noOffRooms = noOffRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    public List<String> getImagesSelectedPath() {
        return imagesSelectedPath;
    }

    public void setImagesSelectedPath(List<String> imagesSelectedPath) {
        this.imagesSelectedPath = imagesSelectedPath;
    }



    public static Creator<ListYourPropertyFormData> getCREATOR() {
        return CREATOR;
    }


    public ListYourPropertyFormData(Parcel in) {
        listingType = in.readString();
    listingType = in.readString();
    propertyType = in.readString();
    noOffRooms = in.readString();
    address = in.readString();
    mState = in.readString();
    city = in.readString();
    mState = in.readString();
    zipCode= in.readString();
    }

    public static final Creator<ListYourPropertyFormData> CREATOR = new Creator<ListYourPropertyFormData>() {
        @Override
        public ListYourPropertyFormData createFromParcel(Parcel in) {
            return new ListYourPropertyFormData(in);
        }

        @Override
        public ListYourPropertyFormData[] newArray(int size) {
            return new ListYourPropertyFormData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString( listingType);
        parcel.writeString( propertyType);
        parcel.writeString( noOffRooms);
        parcel.writeString( address);
        parcel.writeString(mState);
        parcel.writeString( city);
        parcel.writeString(mState);
        parcel.writeString( zipCode);
                                       }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
