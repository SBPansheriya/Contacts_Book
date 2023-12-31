package com.contacts.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.contacts.Adapter.HeaderListAdapter;
import com.contacts.Adapter.KeypadListAdapter;
import com.contacts.Class.Constant;
import com.contacts.Model.Users;
import com.contacts.MyBottomSheetDialog;
import com.contacts.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class KeypadFragment extends Fragment {

    public static KeypadListAdapter keypadListAdapter;
    public static RecyclerView recyclerView;
    String s;
    ArrayList<Users> filteredList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keypad, container, false);

        init(view);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        keypadListAdapter = new KeypadListAdapter(KeypadFragment.this, Constant.usersArrayList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(keypadListAdapter);
        keypadListAdapter.notifyDataSetChanged();

//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
//        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);
//        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        bottomSheetDialog.show();
//
//        ImageView btn_1 = bottomSheetDialog.findViewById(R.id.btn_1);
//        ImageView btn_2 = bottomSheetDialog.findViewById(R.id.btn_2);
//        ImageView btn_3 = bottomSheetDialog.findViewById(R.id.btn_3);
//        ImageView btn_4 = bottomSheetDialog.findViewById(R.id.btn_4);
//        ImageView btn_5 = bottomSheetDialog.findViewById(R.id.btn_5);
//        ImageView btn_6 = bottomSheetDialog.findViewById(R.id.btn_6);
//        ImageView btn_7 = bottomSheetDialog.findViewById(R.id.btn_7);
//        ImageView btn_8 = bottomSheetDialog.findViewById(R.id.btn_8);
//        ImageView btn_9 = bottomSheetDialog.findViewById(R.id.btn_9);
//        ImageView btn_0 = bottomSheetDialog.findViewById(R.id.btn_0);
//        ImageView btn_hash = bottomSheetDialog.findViewById(R.id.btn_hash);
//        ImageView btn_star = bottomSheetDialog.findViewById(R.id.btn_star);
//        ImageView btn_call = bottomSheetDialog.findViewById(R.id.btn_call);
//        ImageView btn_backpress = bottomSheetDialog.findViewById(R.id.btn_backpress);
////        SearchView searchView = bottomSheetDialog.findViewById(R.id.dailer_show);
//        EditText editText = bottomSheetDialog.findViewById(R.id.dailer_show);
//
//        btn_0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "0";
//                editText.setText(s);
//            }
//        });
//
//        btn_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "1";
//                editText.setText(s);
//            }
//        });
//
//        btn_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "2";
//                editText.setText(s);
//            }
//        });
//
//        btn_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "3";
//                editText.setText(s);
//            }
//        });
//
//        btn_4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "4";
//                editText.setText(s);
//            }
//        });
//
//        btn_5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "5";
//                editText.setText(s);
//            }
//        });
//
//        btn_6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "6";
//                editText.setText(s);
//            }
//        });
//
//        btn_7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "7";
//                editText.setText(s);
//            }
//        });
//
//        btn_8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "8";
//                editText.setText(s);
//            }
//        });
//
//        btn_9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "9";
//                editText.setText(s);
//            }
//        });
//
//        btn_hash.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "#";
//                editText.setText(s);
//            }
//        });
//
//        btn_star.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = String.valueOf(editText.getText());
//                s = number + "*";
//                editText.setText(s);
//            }
//        });
//
//        btn_backpress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (editText.length() > 0){
//                    String t = s.substring(0,editText.length() -1);
//                    editText.setText(""+t);
//                }
//                else {
//                    editText.setText("");
//                }
//            }
//        });
//
//        btn_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText()));
//                startActivity(intent);
//            }
//        });
//
//        editText.addTextChangedListener(new TextWatcher() {
//
//            public void afterTextChanged(Editable s) {
//                if (TextUtils.isEmpty(s)){
//                    recyclerView.setVisibility(View.GONE);
//                }
//            }
//
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            public void onTextChanged(CharSequence query, int start, int before, int count) {
//
//                query = query.toString().toLowerCase();
//
//                ArrayList<Users> filteredList = new ArrayList<>();
//
//                for (int i = 0; i < Constant.usersArrayList.size(); i++) {
//
//                    final String number = Constant.usersArrayList.get(i).getPersonPhone().toLowerCase();
//                    if (number.contains(query)) {
//
//                        filteredList.add(Constant.usersArrayList.get(i));
//                    }
//                }
//                if (filteredList.size() > 0){
//                    recyclerView.setVisibility(View.VISIBLE);
//                    keypadListAdapter.setFilteredList(filteredList);
//                }
//                else {
//                    recyclerView.setVisibility(View.GONE);
//                }
//
//            }
//        });
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.keypadrecyclerview);
    }
}