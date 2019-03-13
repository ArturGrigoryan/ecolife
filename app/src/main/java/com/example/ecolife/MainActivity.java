package com.example.ecolife;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String[] p = {"activity_main", "lets_start", "events", "more", "quizz"};
    private int[] lay = {2131296284,  2131296287, 2131296285, 2131296286, 2131296294};
    private String[][][] erarchy = {{{"activity_main", "2131296284"}, {"lets_start"}},{{"lets_start", "2131296287"},{"events", "quizz", "more"}}};
    private static String cPage = "activity_main";
    protected static Activity mMainActivity;
    protected static int points = 0;
    private boolean[] clicked = {false, false, false, false, false};
    private String cLanguage = "us";
    private String[] languages = {"us", "ru", "hy"};
    private String[] hy = {"Բարի գալուստ EcoLife", "Սկսենք", "Իրադարձություններ", "Վիկտորինաներ", "Ավելին", "Հարց 1", "Հարց 2", "Հարց 3", "Ճիշտ 1", "Ճիշտ 2", "Ճիշտ 3", "Սխալ 1", "Սխալ 2", "Սխալ 3", "Անցնել Վիկտորինան", "Ընտրեք ամսաթիվը", "Առաջիկա իրադարձությունները",
            "Հավաքեք թուղթ, պլաստմաս, պոլիէթիլեն և ապակին առանձին ևբերեք Zipple (Malakan Park, 043409090) կամ (ZAKIAN 10 ONLY միայն թուղթ, 091913536): Դուք գիտեք, որ միայն միասին կարող ենք սկսել մեր թափոնների  տեսակավորումը և վերամշակումը: Թուղթ, պլաստիկ, ապակի ... \uD83D\uDE42 Փոքր քայլեր, մեծ հաջողություններով ...",
            "1. Որի վերամշակելն է ավելի հեշտ և քիչ էներգատար", "2. Որ քաղաքի աղբանոցն է տիեզերքից տեսանելի", "3. Քանի տարի է պահանջվում ապակու քայքայման համար։", "4. Արդյոք բոլոր տեսակի թղթերն են վերամշակվում Հայաստանում", "5. Արդյոք բոլոր տեսակի պլաստիկն է վերամշակվում Հայաստանում։",
            "1) Պլաստիկ տարաներ", "2) թղթե փաթեթներ", "2) Պեկին", "1) Նյու Յորք", "1) 1 միլիոն", "2) 5000 տարի", "1) այո", "2) ոչ", "1) գրեթե բոլորը"
    };
    private String[] ru = {"Добро пожаловать в EcoLife", "Начнем", "События", "Викторины", "Больше", "Вопрос 1", "Вопрос 2", "Вопрос 3", "Правильно 1", "Правильно 2", "Правильно 3", "Не правильно 1", "Не правильно 2", "Не правильно 3", "Пройти Викторину", "Выбирите дату", "Ближайшие события",
            "Соберите бумагу, пластик, полиэтилен и стекло отдельно и принесите в Zipple (Малакан Парк, 043409090) или (ТОЛЬКО БУМАГА ZAKIAN 10, 091913536). Вы знаете, что только вместе мы сможем начать сортировку и переработку нашего мусорного бака. Бумага, пластик, стекло ... Обязательно присоединяйтесь \uD83D\uDE42 🙂 Маленькие шаги, с большим успехом ...",
            "1. Переработка которого лнгче, и требует меньше энергии?", "2. Свалка какого города видна из космоса?", "3. Сколько лет требуется для разрушени стекла?", "4. В Армении есть переработка всех типов бумаги ?", "5. В Армении есть переработка всех типов пластика ?",
            "1) Пластиковые тарелки", "2) бумажные пакеты", "2) Пекин", "1) Нью-Йорк", "1) 1 миллион", "2) 5000 лет", "1) Есть", "2) Нету", "1) Да почти"
    };
    private String[] us = {"Welcome to EcoLife", "Lets start", "Events", "Quizz", "More", "Question 1", "Question 2", "Question 3", "True 1", "True 2", "True 3", "False 1", "False 2", "False 3", "Pass The Quizz", "Pick Date", "The Nearest Events",
            "Collect paper, plastic, polyethylene and glass separately and bring to Zipple (Malakan Park, 043409090) or (ZAKIAN 10 ONLY PAPER , 091913536). You know  that only together we can begin sorting and recycling our waste bin. Paper, plastic, glass ...  Be sure to join \uD83D\uDE42 Small steps, with great success...",
            "1. Which one is easier to process and needs less energy ?", "2. Which city's dump is visible from the space ?", "3. How many years is needed for glass decay?", "4. Are all types of papers processed in Armenia", "5. Are all types of plastic processed in Armenia",
            "1) Plastic Plates", "2) Paper bags", "2) Pekin", "1) New York", "1) 1 million", "2) 5000 years", "1) yes", "2) no", "1) almost all"
    };
    private int[] img = {2131099762, 2131099759, 2131099734};
    private boolean isFirstTime = true;
    private int answers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(lay[Arrays.asList(p).indexOf(cPage)]);
        mMainActivity = this;
        initPage();
        updateByLanguage();
    }

    protected void initPage() {
        LinearLayout l = findViewById(R.id.main);
        for (int a = 0; a < l.getChildCount(); a++) {
            TextView v;
            try {
                v = (TextView) l.getChildAt(a);
            } catch (Exception e) {
                continue;
            }
            v.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    TextView t = (TextView) v;
                    for (int a = 0; a < p.length; a++) {
                        if (t.getText().toString().toLowerCase().replace(' ', '_').equals(p[a])) {
                            isFirstTime = false;
                            cPage = t.getText().toString().toLowerCase().replace(' ', '_');
                            setContentView(lay[a]);
                            if(!cPage.equals("events") && !cPage.equals("more") && !cPage.equals("quizz")) {
                                initPage();
                            }
                            if(cPage.equals("quizz")) {
                                initQuestions();
                            }
                            updateByLanguage();
                            updateIcon(findViewById(R.id.flag));
                        }
                    }
                    if(!cLanguage.equals("us")) {
                        String[] l = null;
                        if(cLanguage.equals("ru")) {
                            l = ru;
                        } else if(cLanguage.equals("hy")) {
                            l = hy;
                        }
                        for (int a = 0; a < p.length; a++) {
                            if (us[Arrays.asList(l).indexOf(t.getText())].toLowerCase().replace(' ', '_').equals(p[a])) {
                                isFirstTime = false;
                                cPage = us[Arrays.asList(l).indexOf(t.getText())].toLowerCase().replace(' ', '_');
                                setContentView(lay[a]);
                                if (!cPage.equals("events") && !cPage.equals("more") && !cPage.equals("quizz")) {
                                    initPage();
                                }
                                if (cPage.equals("quizz")) {
                                    initQuestions();
                                }
                                updateByLanguage();
                                updateIcon(findViewById(R.id.flag));
                            }
                        }
                    }
                }
            });
        }
    }


    private void initQuestions() {
        GridLayout g = findViewById(R.id.questions_grid);
        String [] q = {"1. Which one is easier to process and needs less energy ?", "2. Which city's dump is visible from the space ?", "3. How many years is needed for glass decay?", "4. Are all types of papers processed in Armenia", "5. Are all types of plastic processed in Armenia"};
        String [] a = {"1) Plastic Plates", "1) New York", "1) 1 million", "1) yes", "1) almost all"};
        String [] wa = {"2) Paper bags", "2) Pekin", "2) 5000 years", "2) no", "2) no"};
        for(int b = 0; b < q.length; b++) {
            add_text_for_question(g, q[b], getResources().getDrawable(R.drawable.border), 0, false);
            TextView an = add_text_for_question(g, a[b], getResources().getDrawable(R.drawable.border_all), 0, true);
            TextView wAn = add_text_for_question(g, wa[b], getResources().getDrawable(R.drawable.border_all), 1, true);
            add_click(an, false, q.length, b);
            add_click(wAn, true, q.length, b);
        }
    }

    protected void add_click(final TextView t, final boolean isWrong, final int l, final int c) {
        t.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if(!clicked[c]) {
                    if(isWrong) {
                        t.setBackgroundColor(Color.parseColor("#FF6464"));
                        t.setTextColor(Color.WHITE);
                        clicked[c] = true;
                    } else {
                        t.setBackgroundColor(Color.parseColor("#ff669900"));
                        t.setTextColor(Color.WHITE);
                        points++;
                        clicked[c] = true;
                    }
                    answers++;
                    if(answers == 5) {
                        showResults();
                        points = 0;
                    }
                }
            }
        });
    }

    private void showResults() {
        GridLayout g = findViewById(R.id.questions_grid);
        if(cLanguage.equals("us")) {
            TextView an = add_text_for_question(g, "You Have " + points + " points", getResources().getDrawable(R.drawable.border_all), 0, false);
        } else if (cLanguage.equals("ru")) {
            TextView an = add_text_for_question(g, "У вас есть " + points + " очков", getResources().getDrawable(R.drawable.border_all), 0, false);
        } else if (cLanguage.equals("hy")) {
            TextView an = add_text_for_question(g, "Դուք ունեք " + points + " միավոր", getResources().getDrawable(R.drawable.border_all), 0, false);
        }
    }


    protected TextView add_text_for_question(GridLayout g, String txt, Drawable b, int s, boolean setWeight){
        TextView t = new TextView(mMainActivity.getApplicationContext());
        t.setText(txt);
        t.setGravity(Gravity.CENTER);
        t.setTextColor(Color.parseColor("#ff669900"));
        t.setTextSize(10);
        t.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        t.setPadding(25,25,25,25);
        t.setGravity(Gravity.CENTER);
        t.setBackgroundDrawable(b);
        GridLayout.LayoutParams l = new GridLayout.LayoutParams();
        if(setWeight) {
            l.columnSpec = GridLayout.spec(s, 1f);
            l.bottomMargin = 10;
            l.topMargin = 10;
            l.leftMargin = 10;
            l.rightMargin = 10;
        } else {
            l.columnSpec = GridLayout.spec(0, 2);
            l.width = GridLayout.LayoutParams.MATCH_PARENT;
        }
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        g.addView(t, l);
        return t;
    }

    @Override
    public void onBackPressed() {
        clicked = new boolean[]{false, false, false, false, false};
        answers = 0;
        for(int a = 0; a < erarchy.length; a++)
        {
            for(int b = 0; b < erarchy[a].length; b++) {
                for(int c = 0; c < erarchy[a][1].length; c++) {
                    if(!cPage.equals("activity_main") && cPage.equals(erarchy[a][1][c])) {
                        cPage = erarchy[a][0][0];
                        setContentView(Integer.parseInt(erarchy[a][0][1]));
                        initPage();
                        updateByLanguage();
                        updateIcon(findViewById(R.id.flag));
                        return;
                    } else if(cPage.equals("activity_main")) {
                        this.finish();
                    }
                }
            }
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void changeLanguage(View v) {
        isFirstTime = false;
        for(int a = 0; a < languages.length; a++){
            if(a >= languages.length - 1 && languages[a].equals(cLanguage)) {
                cLanguage = languages[0];
                ImageView i = (ImageView) v;
                i.setBackground(getResources().getDrawable(img[Arrays.asList(languages).indexOf(cLanguage)]));
                updateByLanguage();
                break;
            } else if(languages[a].equals(cLanguage)) {
                cLanguage = languages[a + 1];
                ImageView i = (ImageView) v;
                i.setBackground(getResources().getDrawable(img[Arrays.asList(languages).indexOf(cLanguage)]));
                updateByLanguage();
                break;
            }
        }
    }

    private void updateByLanguage() {
        LinearLayout l = findViewById(R.id.main);
        for (int a = 0; a < l.getChildCount(); a++) {
            if (l.getChildAt(a) instanceof Button) {
                Button b = (Button) l.getChildAt(a);
                translate(b);
            } else if (l.getChildAt(a) instanceof GridLayout) {
                GridLayout g = (GridLayout) l.getChildAt(a);
                for (int b = 0; b < g.getChildCount(); b++) {
                    translate(g.getChildAt(b));
                }
            } else if (l.getChildAt(a) instanceof ScrollView) {
                ScrollView s = (ScrollView) l.getChildAt(a);
                for (int b = 0; b < s.getChildCount(); b++) {
                    if (s.getChildAt(b) instanceof LinearLayout) {
                        LinearLayout ll = (LinearLayout) s.getChildAt(b);
                        for (int c = 0; c < ll.getChildCount(); c++) {
                            translate(ll.getChildAt(c));
                        }
                    }
                    if (s.getChildAt(b) instanceof GridLayout) {
                        GridLayout ll = (GridLayout) s.getChildAt(b);
                        for (int c = 0; c < ll.getChildCount(); c++) {
                            translate(ll.getChildAt(c));
                        }
                    }
                    translate(s.getChildAt(b));
                }
            } else if (l.getChildAt(a) instanceof TextView) {
                TextView t = (TextView) l.getChildAt(a);
                translate(t);
            }
        }
        initPage();
    }

    private void translate(View s)
    {
        try {
            final TextView v;
            final Button b;
            if (!isFirstTime) {
                if (s instanceof TextView) {
                    v = (TextView) s;
                    if (cLanguage.equals("hy")) {
                        try {
                            v.setText(hy[Arrays.asList(ru).indexOf(v.getText())]);
                        } catch (Exception e) {
                            v.setText(hy[Arrays.asList(us).indexOf(v.getText())]);
                        }
                    } else if (cLanguage.equals("ru")) {
                        v.setText(ru[Arrays.asList(us).indexOf(v.getText())]);
                    } else if (cLanguage.equals("us")) {
                        v.setText(us[Arrays.asList(hy).indexOf(v.getText())]);
                    }
                } else if (s instanceof Button) {
                    b = (Button) s;
                    if (cLanguage.equals("hy")) {
                        b.setText(hy[Arrays.asList(ru).indexOf(b.getText())]);
                    } else if (cLanguage.equals("ru")) {
                        b.setText(ru[Arrays.asList(us).indexOf(b.getText())]);
                    } else if (cLanguage.equals("us")) {
                        b.setText(us[Arrays.asList(hy).indexOf(b.getText())]);
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {

        }
    }

    private void updateIcon(View v) {
        ImageView i = (ImageView) v;
        i.setBackground(getResources().getDrawable(img[Arrays.asList(languages).indexOf(cLanguage)]));
    }

}