package com.example.grooming_kucing;

public class Grooming {
    private String _id, _nama, _umur, _groom;
    public Grooming (String id, String nama, String umur, String groom) {
        this._id = id;
        this._nama = nama;
        this._umur = umur;
        this._groom = groom;
    }
    public Grooming() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_umur() {
        return _umur;
    }
    public void set_umur(String _umur) {
        this._umur = _umur;
    }
    public String get_groom() {
        return _groom;
    }
    public void set_groom(String _groom) {
        this._groom = _groom;
    }
}
