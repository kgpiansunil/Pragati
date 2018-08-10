package com.example.sunil.pragati.planning;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sunil.pragati.R;

public class SoilTestingManual extends Activity implements OnClickListener {


    private AppCompatDelegate delegate;

    private android.support.v7.widget.Toolbar mToolbar;
    private android.widget.Toolbar Toolbar;
    Button calculateBtn;
    CheckBox manureCredits, convertUnitsBox;
    DatePicker cropSownDatePicker;
    Double nitrogenReqValue, cropLengthModifier, organicMatterModifier, plantingDateModifier, cropStandModifier,
            manureNitrogen = 0.0, manurePhosphate = 0.0,	manurePotash = 0.0;

    EditText manureAmount;
    RadioGroup cropLengthRadioGroup, organicMatterRadioGroup, cropStandRadioGroup;
    Spinner cropSelectionSpn, prevCropSpn, phosphateSpn, potashSpn, manureTypeSpn;
    TextView manureTypePrompt, manureAmountPrompt, nitrogenRequirement, phosphateRequirement, potashRequirement,
            nitrogenUnits, phosphateUnits, potashUnits;
    ScrollView scrollView;
    Boolean convertUnitsBln = false;

    int checkedCropLengthBtn, checkedCropStandBtn, checkedOrganicMatterBtn;
    int selectedCrop, selectedPrevCrop, selectedBaseN, baseValueN;

    final int[] baseValueNitrogen = {50, 40, 60, 50, 150, 150, 35, 150, 100, 150, 150, 60, 150, 35, 130, 120, 130, 60, 75, 50, 20, 20, 100,
            110, 75, 75, 20, 20, 20, 20, 150, 75, 40, 50, 50, 30, 120, 100, 80, 155, 155, 155, 155, 155,
            155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 155, 80,
            60, 135, 150, 45, 50, 20, 100, 80, 150, 100, 60, 60, 20};

    final int[][] barleyPK = {{100, 75, 50, 50, 25, 25}, {100, 100, 75, 50, 25, 0}};
    final int[][] beanPK = {{100, 60, 45, 45, 30, 0}, {100, 75, 50, 40, 25, 0}};
    final int[][] beetPK = {{300, 200, 150, 125, 100, 50}, {225, 175, 125, 100, 75, 25}};
    final int[][] blueberryPK = {{50, 50, 25, 25, 0, 0}, {50, 50, 25, 25, 0, 0}};
    final int[][] broccoliPK = {{400, 300, 200, 200, 150, 100}, {220, 150, 150, 150, 100, 50}};
    final int[][] buckwheatPK = {{80, 60, 30, 30, 30, 15}, {80, 60, 30, 30, 30, 0}};
    final int[][] carrotPK = {{300, 200, 150, 150, 100, 50}, {200, 200, 150, 150, 100, 50}};
    final int[][] celeryPK = {{300, 250, 200, 175, 150, 75}, {400, 350, 250, 200, 150, 100}};
    final int[][] cerealPK = {{134, 101, 50, 50, 34, 34}, {134, 134, 84, 67, 34, 0}};
    final int[][] coniferousPK = {{17, 17, 17, 17, 17, 17}, {34, 34, 34, 34, 34, 34}};
    final int[][] grainCornPK = {{400, 250, 250, 130, 130, 70}, {400, 250, 250, 130, 130, 70}};
    final int[][] silageCornPK = {{120, 90, 45, 45, 0, 0}, {200, 150, 100, 75, 50, 0}};
    final int[][] cranberryPK = {{135, 115, 90, 70, 50, 0}, {135, 115, 90, 70, 50, 0}};
    final int[][] cucumberPK = {{225, 225, 150, 150, 75, 75}, {150, 100, 75, 75, 50, 0}};
    final int[][] deciduousPK = {{25, 25, 25, 25, 25, 25}, {50, 50, 50, 50, 50, 50}};
    final int[][] fallryePK = {{100, 60, 45, 45, 30, 30}, {100, 60, 45, 45, 30, 0}};
    final int[][] fieldpeaPK = {{120, 80, 60, 60, 40, 0}, {100, 75, 40, 40, 25, 0}};
    final int[][] fruittreesPK = {{270, 230, 140, 95, 60, 0}, {225, 190, 145, 110, 75, 0}};
    final int[][] garlicPK = {{250, 220, 180, 140, 85, 50}, {175, 135, 100, 70, 50, 25}};
    final int[][] grasshayPK = {{75, 60, 50, 40, 15, 0}, {160, 130, 100, 75, 40, 0}};
    final int[][] greenpeaPK = {{100, 60, 45, 45, 30, 0}, {75, 45, 30, 30, 0, 0}};
    final int[][] legumehayPK = {{90, 70, 55, 40, 40, 40}, {250, 220, 170, 140, 75, 75}};
    final int[][] legumepasturePK = {{90, 70, 55, 40, 15, 0}, {250, 220, 170, 140, 75, 0}};
    final int[][] legumeseededPK = {{140, 120, 100, 80, 80, 40}, {200, 160, 120, 80, 80, 60}};
    final int[][] lettucePK = {{400, 400, 300, 300, 200, 100}, {220, 220, 150, 150, 150, 100}};
    final int[][] mixedforagePK = {{130, 110, 85, 60, 32, 0}, {230, 185, 160, 135, 85, 0}};
    final int[][] mixedgrainPK = {{90, 70, 40, 40, 40, 20}, {90, 70, 45, 30, 30, 0}};
    final int[][] mixedhayPK = {{75, 60, 50, 40, 15, 0}, {160, 130, 100, 75, 40, 0}};
    final int[][] oatPK = {{100, 75, 60, 60, 30, 30}, {80, 60, 30, 30, 30, 0}};
    final int[][] onionPK = {{300, 220, 150, 150, 50, 50}, {220, 120, 90, 90, 60, 45}};
    final int[][] pepperPK = {{300, 200, 150, 125, 100, 50}, {225, 175, 125, 100, 75, 25}};
    final int[][] potatoPK = {{400, 275, 200, 200, 135, 135}, {270, 200, 135, 135, 135, 135}};
    final int[][] pumpkinPK = {{300, 200, 150, 125, 100, 50}, {225, 175, 125, 100, 75, 25}};
    final int[][] radishPK = {{150, 100, 60, 50, 40, 20}, {100, 75, 50, 40, 25, 0}};
    final int[][] raspberryPK = {{135, 115, 90, 70, 50, 0}, {135, 115, 90, 70, 50, 0}};
    final int[][] rhubarbPK = {{300, 200, 150, 125, 100, 50}, {300, 250, 175, 150, 100, 75}};
    final int[][] rutabagaPK = {{200, 200, 150, 150, 90, 90}, {180, 180, 90, 90, 45, 45}};
    final int[][] ryegrassPK = {{140, 120, 100, 80, 80, 40}, {200, 150, 100, 100, 100, 50}};
    final int[][] soybeanPK = {{120, 80, 60, 60, 40, 40}, {100, 75, 40, 40, 25, 0}};
    final int[][] spinachPK = {{150, 100, 60, 50, 40, 20}, {300, 250, 175, 150, 100, 75}};
    final int[][] strawberryPK = {{200, 160, 115, 75, 40, 0}, {150, 125, 80, 60, 35, 0}};
    final int[][] tomatoPK = {{350, 250, 200, 175, 150, 75}, {350, 250, 175, 150, 100, 75}};
    final int[][] wheatPK = {{120, 90, 45, 45, 30, 30}, {120, 120, 75, 60, 30, 0}};
    final int[][] millingwheatPK = {{100, 60, 45, 45, 30, 30}, {100, 100, 60, 45, 30, 0}};
    final int[][] winterwheatPK = {{100, 60, 45, 45, 30, 30}, {100, 60, 45, 30, 30, 0}};


    final double[] poorStand = {0, 0, 0, 8.9, 0};
    final double[] fairStand = {35.6, 17.8, 8.9, 8.9, 0};
    final double[] goodStand = {71.2, 35.6, 17.8, 8.9, -13.35};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_testing_manual);


        scrollView = (ScrollView) findViewById(R.id.scrollView);

        cropSelectionSpn = (Spinner) findViewById(R.id.cropSelectionSpn);
        ArrayAdapter<CharSequence> cropSelectionAdapter = ArrayAdapter.createFromResource(this, R.array.cropsToSelect, android.R.layout.simple_spinner_item);
        cropSelectionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cropSelectionSpn.setAdapter(cropSelectionAdapter);

        prevCropSpn = (Spinner) findViewById(R.id.prevCropSpn);
        ArrayAdapter<CharSequence> prevCropAdapter = ArrayAdapter.createFromResource(this, R.array.prevCrops, android.R.layout.simple_spinner_item);
        prevCropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prevCropSpn.setAdapter(prevCropAdapter);

        phosphateSpn = (Spinner) findViewById(R.id.phosphateSpn);
        ArrayAdapter<CharSequence> phosphateAdapter = ArrayAdapter.createFromResource(this, R.array.soilTestRatings, android.R.layout.simple_spinner_item);
        phosphateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phosphateSpn.setAdapter(phosphateAdapter);

        potashSpn = (Spinner) findViewById(R.id.potashSpn);
        ArrayAdapter<CharSequence> potashAdapter = ArrayAdapter.createFromResource(this, R.array.soilTestRatings, android.R.layout.simple_spinner_item);
        potashAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        potashSpn.setAdapter(potashAdapter);

        manureTypeSpn = (Spinner) findViewById(R.id.manureTypeSpn);
        ArrayAdapter<CharSequence> manureTypeAdapter = ArrayAdapter.createFromResource(this, R.array.manureTypes, android.R.layout.simple_spinner_item);
        manureTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        manureTypeSpn.setAdapter(manureTypeAdapter);

        cropLengthRadioGroup = (RadioGroup) findViewById(R.id.cropLengthRadioGroup);
        cropSownDatePicker = (DatePicker) findViewById(R.id.cropSownDatePicker);
        manureCredits = (CheckBox) findViewById(R.id.manureCreditsCheckBox);
        manureTypePrompt = (TextView) findViewById(R.id.manureTypePrompt);
        manureAmountPrompt = (TextView) findViewById(R.id.manureAmountPrompt);
        manureAmount = (EditText) findViewById(R.id.manureAmount);
        cropStandRadioGroup = (RadioGroup) findViewById(R.id.cropStandRadioGroup);
        organicMatterRadioGroup = (RadioGroup) findViewById(R.id.organicMatterRadioGroup);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        nitrogenRequirement = (TextView) findViewById(R.id.nitrogenRequirement);
        phosphateRequirement = (TextView) findViewById(R.id.phosphateRequirement);
        potashRequirement = (TextView) findViewById(R.id.potashRequirement);
        convertUnitsBox = (CheckBox) findViewById(R.id.convertUnitsBox);
        nitrogenUnits = (TextView) findViewById(R.id.nitrogenUnits);
        phosphateUnits = (TextView) findViewById(R.id.phosphateUnits);
        potashUnits = (TextView) findViewById(R.id.potashUnits);

        manureCredits.setOnClickListener(this);
        calculateBtn.setOnClickListener(this);
        convertUnitsBox.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v == manureCredits) {
            if (manureCredits.isChecked()) {
                manureTypePrompt.setVisibility(View.VISIBLE);
                manureTypeSpn.setVisibility(View.VISIBLE);
                manureAmountPrompt.setVisibility(View.VISIBLE);
                manureAmount.setVisibility(View.VISIBLE);

            } else {
                manureTypePrompt.setVisibility(View.GONE);
                manureTypeSpn.setVisibility(View.GONE);
                manureAmountPrompt.setVisibility(View.GONE);
                manureAmount.setVisibility(View.GONE);
            }
        }

        if (v == calculateBtn) {
            selectedCrop = cropSelectionSpn.getSelectedItemPosition();

            if (manureCredits.isChecked())
                getManureCredits();
            else {
                clearManureCredits();
            }

            calculateNitrogenRequirement();
            calculatePhosphateRequirement();
            calculatePotashRequirement();

            scrollView.setSmoothScrollingEnabled(true);
            //scrollView.smoothScrollTo(0, scrollView.getMaxScrollAmount());
            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        }

        if (v == convertUnitsBox) {
            convertUnits();
        }

    }

    private void getManureCredits() {
        switch (manureTypeSpn.getSelectedItemPosition()) {
            case 0: applyManureCredits(30, 9, 10, 1000);
                break;
            case 1: applyManureCredits(17, 9, 22, 1);
                break;
            case 2: applyManureCredits(23, 6, 20, 1000);
                break;
            case 3: applyManureCredits(13, 4, 12, 1);
                break;
            case 4: applyManureCredits(32, 35, 34, 1000);
                break;
            case 5: applyManureCredits(18, 26, 16, 1);
                break;
        }
    }

    private void applyManureCredits(int N, int P, int K, int denominator) {
        String manureEnteredStr = manureAmount.getText().toString();

        if (manureEnteredStr == null) {
            clearManureCredits();
        } else {
            double manureEntered = Double.parseDouble(manureEnteredStr);
            manureNitrogen = manureEntered * N / denominator;
            manurePhosphate = manureEntered * P / denominator;
            manurePotash = manureEntered * K / denominator;
        }
    }

    private void clearManureCredits() {
        manureNitrogen = 0.0;
        manurePhosphate = 0.0;
        manurePotash = 0.0;
    }

    public void calculateNitrogenRequirement() {
        getCropLength();
        getPlantingDate();
        getCropStand();
        getOrganicMatter();

        baseValueN = baseValueNitrogen[selectedCrop];

        nitrogenReqValue = baseValueN * cropLengthModifier - plantingDateModifier -
                cropStandModifier - organicMatterModifier - manureNitrogen;

        if (convertUnitsBox.isChecked())
            nitrogenReqValue = nitrogenReqValue / 0.89;

        nitrogenRequirement.setText(formattedString(nitrogenReqValue));
    }

    public void getCropLength() {
        switch (cropLengthRadioGroup.getCheckedRadioButtonId()) {
            case R.id.cropLengthEarly : cropLengthModifier = 0.9;
                break;
            case R.id.cropLengthFull : cropLengthModifier = 1.0;
                break;
            default : cropLengthModifier = 0.0;
                break;
        }
    }

    public void getPlantingDate() {
        if (cropSownDatePicker.getMonth() <= 4 && cropSownDatePicker.getDayOfMonth() <= 25) {
            plantingDateModifier = 0.0;
        } else if (cropSownDatePicker.getMonth() >= 5 && cropSownDatePicker.getDayOfMonth() >= 9) {
            plantingDateModifier = 29.37;
        } else if (cropSownDatePicker.getMonth() == 5) {
            if (cropSownDatePicker.getDayOfMonth() >= 2 && cropSownDatePicker.getDayOfMonth() <= 8)	{
                plantingDateModifier = 19.58;
            } else plantingDateModifier = 9.79;
        } else if (cropSownDatePicker.getMonth() == 4) {
            if (cropSownDatePicker.getDayOfMonth() >= 26)
                plantingDateModifier = 9.79;
        } else plantingDateModifier = 0.0;
    }

    public void getCropStand() {
        switch (cropStandRadioGroup.getCheckedRadioButtonId()) {
            case R.id.poorBtn : cropStandModifier = poorStand[prevCropSpn.getSelectedItemPosition()];
                break;
            case R.id.fairBtn : cropStandModifier = fairStand[prevCropSpn.getSelectedItemPosition()];
                break;
            case R.id.goodBtn : cropStandModifier = goodStand[prevCropSpn.getSelectedItemPosition()];
                break;
            default : cropStandModifier = 0.0;
                break;
        }
    }

    public void getOrganicMatter() {
        switch (organicMatterRadioGroup.getCheckedRadioButtonId()) {
            case R.id.lessOrganicBtn : organicMatterModifier = 0.0;
                break;
            case R.id.moreOrganicBtn : organicMatterModifier = 13.35;
                break;
            default : organicMatterModifier = 0.0;
                break;
        }
    }

    private void calculatePhosphateRequirement() {
        double phosphateReqValue = getPhosphate() - manurePhosphate;

        if (convertUnitsBox.isChecked())
            phosphateReqValue = phosphateReqValue / 0.89;

        phosphateRequirement.setText(formattedString(phosphateReqValue));

    }

    private double getPhosphate() {
        double phosphate = 0;

        switch (selectedCrop) {
            case 0: phosphate = (double) barleyPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 1: phosphate = (double) beanPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 2: phosphate = (double) beetPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 3: phosphate = (double) blueberryPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 4: phosphate = (double) broccoliPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 5: phosphate = (double) broccoliPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 6: phosphate = (double) buckwheatPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 7: phosphate = (double) broccoliPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 8: phosphate = (double) carrotPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 9: phosphate = (double) broccoliPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 10: phosphate = (double) celeryPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 11: phosphate = (double) cerealPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 12: phosphate = (double) broccoliPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 13: phosphate = (double) coniferousPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 14: phosphate = (double) grainCornPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 15: phosphate = (double) silageCornPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 16: phosphate = (double) grainCornPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 17: phosphate = (double) cranberryPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 18: phosphate = (double) cucumberPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 19: phosphate = (double) deciduousPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 20: phosphate = (double) fallryePK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 21: phosphate = (double) fieldpeaPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 22: phosphate = (double) fruittreesPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 23: phosphate = (double) garlicPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 24: phosphate = (double) grasshayPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 25: phosphate = (double) grasshayPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 26: phosphate = (double) greenpeaPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 27: phosphate = (double) legumehayPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 28: phosphate = (double) legumepasturePK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 29: phosphate = (double) legumeseededPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 30: phosphate = (double) lettucePK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 31: phosphate = (double) mixedforagePK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 32: phosphate = (double) mixedgrainPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 33: phosphate = (double) mixedhayPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 34: phosphate = (double) mixedhayPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 35: phosphate = (double) oatPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 36: phosphate = (double) onionPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 37: phosphate = (double) carrotPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 38: phosphate = (double) pepperPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 62: phosphate = (double) pumpkinPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 63: phosphate = (double) radishPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 64: phosphate = (double) raspberryPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 65: phosphate = (double) rhubarbPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 66: phosphate = (double) rutabagaPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 67: phosphate = (double) ryegrassPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 68: phosphate = (double) soybeanPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 69: phosphate = (double) spinachPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 70: phosphate = (double) pumpkinPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 71: phosphate = (double) strawberryPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 72: phosphate = (double) tomatoPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 73: phosphate = (double) wheatPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 74: phosphate = (double) millingwheatPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
            case 75: phosphate = (double) winterwheatPK[0][phosphateSpn.getSelectedItemPosition()];
                break;
        }

        if (selectedCrop >= 39 && selectedCrop <= 61)
            phosphate = (double) potatoPK[0][phosphateSpn.getSelectedItemPosition()];

        return phosphate;
    }

    private void calculatePotashRequirement() {
        double potashReqValue = getPotash() - manurePotash;

        if (convertUnitsBox.isChecked())
            potashReqValue = potashReqValue / 0.89;

        potashRequirement.setText(formattedString(potashReqValue));
    }

    private double getPotash() {
        double potash = 0;

        switch (selectedCrop) {
            case 0: potash = (double) barleyPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 1: potash = (double) beanPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 2: potash = (double) beetPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 3: potash = (double) blueberryPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 4: potash = (double) broccoliPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 5: potash = (double) broccoliPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 6: potash = (double) buckwheatPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 7: potash = (double) broccoliPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 8: potash = (double) carrotPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 9: potash = (double) broccoliPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 10: potash = (double) celeryPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 11: potash = (double) cerealPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 12: potash = (double) broccoliPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 13: potash = (double) coniferousPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 14: potash = (double) grainCornPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 15: potash = (double) silageCornPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 16: potash = (double) grainCornPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 17: potash = (double) cranberryPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 18: potash = (double) cucumberPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 19: potash = (double) deciduousPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 20: potash = (double) fallryePK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 21: potash = (double) fieldpeaPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 22: potash = (double) fruittreesPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 23: potash = (double) garlicPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 24: potash = (double) grasshayPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 25: potash = (double) grasshayPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 26: potash = (double) greenpeaPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 27: potash = (double) legumehayPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 28: potash = (double) legumepasturePK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 29: potash = (double) legumeseededPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 30: potash = (double) lettucePK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 31: potash = (double) mixedforagePK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 32: potash = (double) mixedgrainPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 33: potash = (double) mixedhayPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 34: potash = (double) mixedhayPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 35: potash = (double) oatPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 36: potash = (double) onionPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 37: potash = (double) carrotPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 38: potash = (double) pepperPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 62: potash = (double) pumpkinPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 63: potash = (double) radishPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 64: potash = (double) raspberryPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 65: potash = (double) rhubarbPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 66: potash = (double) rutabagaPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 67: potash = (double) ryegrassPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 68: potash = (double) soybeanPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 69: potash = (double) spinachPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 70: potash = (double) pumpkinPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 71: potash = (double) strawberryPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 72: potash = (double) tomatoPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 73: potash = (double) wheatPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 74: potash = (double) millingwheatPK[1][potashSpn.getSelectedItemPosition()];
                break;
            case 75: potash = (double) winterwheatPK[1][potashSpn.getSelectedItemPosition()];
                break;
        }

        if (selectedCrop >= 39 && selectedCrop <= 61)
            potash = (double) potatoPK[1][potashSpn.getSelectedItemPosition()];

        return potash;
    }

    private void convertUnits() {
        if (convertUnitsBox.isChecked()) {
            calculateNitrogenRequirement();
            calculatePhosphateRequirement();
            calculatePotashRequirement();

            nitrogenUnits.setText("kg/ha");
            phosphateUnits.setText("kg/ha");
            potashUnits.setText("kg/ha");
        } else {
            calculateNitrogenRequirement();
            calculatePhosphateRequirement();
            calculatePotashRequirement();

            nitrogenUnits.setText("lb/ac");
            phosphateUnits.setText("lb/ac");
            potashUnits.setText("lb/ac");
        }
    }

    private String formattedString (double d) {
        return String.format("%.1f", d);
    }

}