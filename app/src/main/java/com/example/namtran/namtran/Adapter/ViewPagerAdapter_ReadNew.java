package com.example.namtran.namtran.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_Cuoi;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_Dulich;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_GiaiTri;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_GiaoDuc;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_KhoaHoc;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_TheGioi;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_TheThao;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_Xahoi;
import com.example.namtran.namtran.Fragment_ReadNew.ReadNew_Xe;

/**
 * Created by Nam Tran on 8/19/2015.
 */
public class ViewPagerAdapter_ReadNew extends FragmentStatePagerAdapter {

    CharSequence Title[];
    int NumberTAB;


    public ViewPagerAdapter_ReadNew(FragmentManager fm, CharSequence[] title, int numberTAB) {
        super(fm);
        Title = title;
        NumberTAB = numberTAB;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0)
        {
            ReadNew_Xahoi readNew_xahoi = new ReadNew_Xahoi();
            return readNew_xahoi;
        }
        else if (position == 1)
        {
            ReadNew_TheThao readNew_theThao = new ReadNew_TheThao();
            return readNew_theThao;
        }
        else if (position == 2)
        {
            ReadNew_TheGioi readNew_theGioi = new ReadNew_TheGioi();
            return readNew_theGioi;
        }
        else if (position == 3)
        {
            ReadNew_GiaoDuc readNew_giaoDuc = new ReadNew_GiaoDuc();
            return readNew_giaoDuc;
        }
        else if (position == 4)
        {
            ReadNew_GiaiTri readNew_giaiTri = new ReadNew_GiaiTri();
            return readNew_giaiTri;
        }
        else if (position == 5)
        {
            ReadNew_KhoaHoc readNew_khoaHoc = new ReadNew_KhoaHoc();
            return readNew_khoaHoc;
        }
        else if (position == 6)
        {
            ReadNew_Xe readNew_xe = new ReadNew_Xe();
            return readNew_xe;
        }
        else if (position == 7)
        {
            ReadNew_Dulich readNew_dulich = new ReadNew_Dulich();
            return readNew_dulich;
        }
        else
        {
            ReadNew_Cuoi readNew_cuoi = new ReadNew_Cuoi();
            return readNew_cuoi;
        }
    }

    @Override
    public int getCount() {
        return NumberTAB;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Title[position];
    }
}
