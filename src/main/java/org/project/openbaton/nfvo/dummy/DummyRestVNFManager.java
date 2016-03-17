package org.project.openbaton.nfvo.dummy;

import org.openbaton.catalogue.mano.record.VNFCInstance;
import org.openbaton.catalogue.mano.record.VNFRecordDependency;
import org.openbaton.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.openbaton.catalogue.nfvo.Action;
import org.openbaton.catalogue.nfvo.VimInstance;
import org.openbaton.common.vnfm_sdk.rest.AbstractVnfmSpringReST;
import org.springframework.boot.SpringApplication;

import java.util.List;

/**
 * Created by lto on 27/05/15.
 */
public class DummyRestVNFManager extends AbstractVnfmSpringReST {

    @Override
    public VirtualNetworkFunctionRecord instantiate(VirtualNetworkFunctionRecord vnfr, Object scripts, List<VimInstance> vimInstances) throws Exception {
        log.info("Instantiation of VirtualNetworkFunctionRecord " + vnfr.getName());
        log.trace("Instantiation of VirtualNetworkFunctionRecord " + vnfr);

        log.debug("Number of events: " + vnfr.getLifecycle_event().size());
        log.trace("I've finished initialization of vnf " + vnfr.getName() + " in facts there are only " + vnfr.getLifecycle_event().size() + " events");
        vnfr.setVendor("Updated Vendor");
        /*

        */
        return vnfr;
    }

    @Override
    public void query() {

    }

    @Override
    public VirtualNetworkFunctionRecord scale(Action scaleInOrOut, VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, VNFCInstance component, Object scripts, VNFRecordDependency dependency) throws Exception {
        return virtualNetworkFunctionRecord;
    }


    @Override
    public void checkInstantiationFeasibility() {

    }

    @Override
    public VirtualNetworkFunctionRecord heal(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, VNFCInstance component, String cause) throws Exception {
        return virtualNetworkFunctionRecord;
    }

    @Override
    public void updateSoftware() {

    }

    @Override
    public VirtualNetworkFunctionRecord modify(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord, VNFRecordDependency dependency) {
        log.trace("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord);
        log.debug("Adding relation with VirtualNetworkFunctionRecord " + virtualNetworkFunctionRecord.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return virtualNetworkFunctionRecord;
    }


    @Override
    public void upgradeSoftware() {

    }

    @Override
    public VirtualNetworkFunctionRecord terminate(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return virtualNetworkFunctionRecord;
    }

    @Override
    public void handleError(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {

    }

    @Override
    protected void checkEmsStarted(String vduHostname) {
        try {
            log.debug("waiting for 10 seconds while ems starts");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VirtualNetworkFunctionRecord start(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return virtualNetworkFunctionRecord;
    }

    @Override
    public VirtualNetworkFunctionRecord configure(VirtualNetworkFunctionRecord virtualNetworkFunctionRecord) {
        return virtualNetworkFunctionRecord;
    }

    public static void main(String[] args) {
        SpringApplication.run(DummyRestVNFManager.class, args);
    }

    @Override
    public void NotifyChange() {

    }
}
