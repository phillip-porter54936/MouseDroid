/**
 * Created by Phillip on 4/23/2017.
 */

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothProfile;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class Bluetooth_Pointer_Driver extends Activity
{
    public final static int REQUEST_ENABLE_BT = 1;

    public Bluetooth_Pointer_Driver()
    {
        // Setup Bluetooth
        BluetoothAdapter Ba = BluetoothAdapter.getDefaultAdapter();

        if (Ba != null)
        {
            // Enable bluetooth
            if (!Ba.isEnabled())
            {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
        else
        {
            // Error
            System.exit(-1);
        }

        // Get paired devices
        Set<BluetoothDevice> pairedDevices = Ba.getBondedDevices();
        ArrayList<DeviceItem> deviceItemList = new ArrayList<DeviceItem>();


        if (pairedDevices.size() > 0)
        {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices)
            {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
            }

            // Check for one in range



        }
        else // Look for more
        {

        }
    }

    private class Mouse_Profile implements BluetoothProfile
    {
        @Override
        public List<BluetoothDevice> getConnectedDevices()
        {
            return null;
        }

        @Override
        public List<BluetoothDevice> getDevicesMatchingConnectionStates(int[] states)
        {

            return null;
        }

        @Override
        public int getConnectionState(BluetoothDevice device) {
            return 0;
        }

        @Override
        public boolean equals(Object obj)
        {
            return super.equals(obj);
        }
    }
}
