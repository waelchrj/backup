package edu.erau.eagleeye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class is an implementation of an activity such that whenever it is called it will display
 * the logo of the application as well as a series of text boxes with values determined by the matching
 * Node previously found by the black box matching method. The string values within the text boxes can be
 * modified by calling the catchBuildingInfo with parameter "INode".
 * @author Mike Roy
 * @version 1.0
 */
public class FoundBuilding extends AppCompatActivity {

    //these are variables that will be used to store the name and building remark used by the
    //activity as part of the output to the user.
    public static String BuildingName;
    public static String BuildingRemark;
    public static Integer referencePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_building);

        TextView buildingNameBox = (TextView)findViewById(R.id.buildingName);
        TextView buildingRemarkBox = (TextView)findViewById(R.id.remarks);
        ImageView referenceBuilding= (ImageView)findViewById(R.id.referencePicture);

        //sets the text boxes to the value held within the variables
        buildingNameBox.setText(BuildingName);
        buildingRemarkBox.setText(BuildingRemark);
        referenceBuilding.setImageResource(referencePic);

        // Adds listener to Take Another Picture button.
        Button goBackButton = (Button)findViewById(R.id.goBackButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * This method catches the node object that has been detected as a match. Then sets the
     * variables for the building name and building remark to match those that are contained by the
     * node object.
     * @param matchingNode: INode
     */
    public void catchBuildingInfo (INode matchingNode){

        //sets the string variables to equal the value of Name and Remark which are contained
        //in the node object of the matched building.
        //NOTE: This implementation is not complete until the Node object is well defined.
        //NOTE: must change .toString to method or attribute within local INode object for proper functionality/
        BuildingName = matchingNode.toString();
        BuildingRemark = matchingNode.toString();

        //calls method to set the value of the text boxes to reflect the information of the matched
        //building
        setTextBoxes("a", "b");
    }

    /**
     * This method is called whenever the values store in the variables buildingName and buildingRemark
     * are wished to be loaded into the text boxes present within this activity.
     */
    public void setTextBoxes(String name, String remark){
        //create objects corresponding to each text box on this activity that need to be defined
        TextView buildingNameBox = (TextView)findViewById(R.id.buildingName);
        TextView buildingRemarkBox = (TextView)findViewById(R.id.remarks);

        //sets the text boxes to the value held within the variables
        buildingNameBox.setText(BuildingName);
        buildingRemarkBox.setText(BuildingRemark);
    }
}
